package com.controller;
/*
 * @ClassName:LoginController
 * @Description: 手机号、邮箱注册；用户名、手机号、邮箱登录；注销；用户信息页面；
 * @Author qiao
 * @Date 2018/8/1 10:03
 **/

import com.model.Code;
import com.model.People;
import com.rmi.Server;
import com.service.UserService;
import com.service.thirdParty.EmailService;
import com.service.thirdParty.TelService;
import com.util.Result;
import com.util.task5.DESUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.Random;

@Controller
@Component

public class LoginController {
    private static Logger logger = Logger.getLogger("LoginController.class");
    @Autowired
    Server server;
    private UserService userService;

    private TelService telService;

    private EmailService emailService;

    /**
     * @param {name}、{password}
     * @return
     * @mathodName login
     * @Description 登录接口
     * @date 2018/7/31 21:52
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpServletResponse response, People people, DESUtil desUtil) throws UnsupportedEncodingException {

        logger.info("login:参数" + request.getParameter("password") + request.getParameter("name"));

        userService = server.getUserService();

        //MD5加密加盐
        people.setPassword(DigestUtils.md5Hex(people.getPassword()) + "abc");

        String user = people.getName();
        String password = people.getPassword();

        People people1 = userService.login(user, password);

        logger.info("验证结果" + people1);
        //登录时间
        people.setLoginTime(System.currentTimeMillis());
        //DES加密
        String str1 = desUtil.encryptFromLong(people.getLoginTime());
        String str2 = desUtil.encryptFromLong(people.getId());

        if (people1 != null) {
            logger.info("登录成功");
            //token：登录时间、用户Id、用户姓名加密组成
            String name = desUtil.encrypt(people1.getName());
            String token = desUtil.encrypt(str1 + "|" + name + "|" + str2);
//            userService.updatePeople(people);
            //添加cookie
            Cookie namecookie = new Cookie("name", name);// 新建一个Cookie对象
            Cookie tokencookie = new Cookie("token", token);
            namecookie.setMaxAge(30 * 60);// 设置为30min，生命周期
            tokencookie.setMaxAge(30 * 60);
            namecookie.setPath("/");//设置Cookie的使用路径
            tokencookie.setPath("/");
            response.addCookie(namecookie);// 保存cookie到客户端
            response.addCookie(tokencookie);
            return "redirect:people";
        } else {
            logger.info("登陆失败");
            return "fail";
        }
    }

    /**
     * @param
     * @return
     * @mathodName test
     * @Description 登录页面
     * @date 2018/8/3 21:12
     */
    @RequestMapping(value = "/loginPage")
    public ModelAndView test(ModelAndView modelAndView) {
        modelAndView.setViewName("login");
        return modelAndView;
    }

    /**
     * @param
     * @return
     * @mathodName loginOut
     * @Description 注销
     * @date 2018/8/3 21:13
     */
    @RequestMapping(value = "/logOut")
    public String loginOut(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("name")) {
                cookie.setValue(null);
                cookie.setMaxAge(0);// 立即销毁cookie
                cookie.setPath("/");
                response.addCookie(cookie);
                request.getSession().invalidate();
                request.getSession().removeAttribute("name");
                break;
            }
        }
        return "redirect:/people";
    }

    /**
     * @param {name} {password}
     * @return
     * @mathodName register
     * @Description 手机号注册接口
     * @date 2018/8/3 21:13
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(People people, HttpServletRequest request, Result result) {

        userService = server.getUserService();

        logger.info("register参数：name、password" + people.toString());

        String randCode = request.getParameter("code");
        long tel = Long.valueOf(request.getParameter("tel"));
        System.out.println(randCode + "" + tel);
        //判断姓名密码非空
        if (people.getName().equals("") || people.getPassword().equals("")) {
            result.setCode(-100);
            result.setMsg("姓名和密码不能为空");
            return "json";
        }
        people.setCreatTime(System.currentTimeMillis());
        //判断姓名存在
        People people1 = userService.selectByName(people.getName());
        if (people1 != null) {
            logger.info("数据库信息" + people1.toString());
            String name = people1.getName();
            result.setCode(-101);
            result.setMsg("已注册");
            return "json";
        }
        //MD5加密加盐，加了固定的字符串
        people.setPassword(DigestUtils.md5Hex(people.getPassword()) + "abc");
        if (telService.checkRandCode(randCode, tel)) {
            logger.info("短信验证成功");
            people.setStatus(1);
            userService.addUser(people);
            result.setCode(0);
            result.setMsg("注册成功,请登录");
            return "json";
        }
        result.setCode(-103);
        result.setMsg("验证码不正确");
        return "json";
    }


    /**
     * @param tel, result
     * @return java.lang.String
     * @mathodName sendCode
     * @Description 发送手机验证码
     * @date 2018/9/8 20:56
     */
    @RequestMapping(value = "/telCode", method = RequestMethod.GET)
    public String sendCode(Long tel, Result result) {
        logger.info("sendCode：tel = " + tel);

        telService = server.getTelService();

        //获取随机验证码
        String rand_Code = telService.getRangCode();
        //查询code表，手机号信息验证
        Code code = telService.checkTelSum(tel);
        if (code == null) {
            //次数超过5次
            result.setCode(-101);
            result.setMsg("今日次数以达上限");
            return "json";
        }
        if (telService.sendRandCode(code, rand_Code)) {
            result.setCode(0);
            result.setMsg("发送成功");
        } else {
            result.setCode(-100);
            result.setMsg("发送失败，请重试");
        }
        return "json";
    }


    /**
     * @param
     * @return
     * @mathodName registerPage
     * @Description 手机号注册页
     * @date 2018/8/10 22:31
     */
    @RequestMapping(value = "/registerPage")
    public ModelAndView registerPage(ModelAndView modelAndView) {
        modelAndView.setViewName("telRegister");
        return modelAndView;
    }

    /**
     * @param people, request, result
     * @return java.lang.String
     * @mathodName emailRegister
     * @Description 邮箱注册，发送邮件
     * @date 2018/9/6 11:11
     */
    @RequestMapping(value = "/emailRegister", method = RequestMethod.POST)
    public String emailRegister(People people, HttpServletRequest request, Result result) {

        logger.info("register参数：" + people.toString());

        userService = server.getUserService();
        emailService = server.getEmailService();

        String randCode = String.valueOf(100000 + new Random().nextInt(899999));   //随机码
        String email = request.getParameter("email");   //邮箱
        String emailType = "email";

        logger.info(randCode + " | " + email);

        //判断姓名密码非空
        if (people.getName().equals("") || people.getPassword().equals("")) {
            result.setCode(-100);
            result.setMsg("姓名和密码不能为空");
            return "json";
        }
        //判断姓名存在
        if (userService.selectByName(people.getName()) != null) {
            result.setCode(-101);
            result.setMsg("已注册");
            return "json";
        }
        //发送邮件
        if (emailService.sentEmail(request, randCode, emailType)) {
            //MD5加密加盐，加了固定的字符串
            people.setPassword(DigestUtils.md5Hex(people.getPassword()) + "abc");
            people.setCreatTime(System.currentTimeMillis());
            people.setEmail(randCode);
            people.setStatus(3);
            userService.addUser(people);
            result.setCode(0);
            result.setMsg("发送邮件成功，请验证");
        } else {
            result.setCode(-102);
            result.setMsg("发送邮件失败，请重试");
        }
        return "json";
    }

    /**
     * @param modelAndView, request, result, people
     * @return org.springframework.web.servlet.ModelAndView
     * @mathodName checkEmail
     * @Description 邮箱注册验证
     * @date 2018/9/5 23:28
     */
    @RequestMapping(value = "/email", method = RequestMethod.GET)
    public ModelAndView checkEmail(ModelAndView modelAndView, HttpServletRequest request, Result result, People people) {

        logger.info(people.toString());

        userService = server.getUserService();
        emailService = server.getEmailService();

        String email = request.getParameter("email");
        String randCode = request.getParameter("randCode");
        String name = request.getParameter("name");

        people.setEmail(email);
        people.setUpdateTime(System.currentTimeMillis());
        //邮箱验证
        if (emailService.checkEmail(randCode, name)) {
            result.setMsg("验证成功");
            people.setStatus(1);
            //更新数据库信息
            userService.updatePeople(people);
            modelAndView.setViewName("login");
        } else {
            result.setMsg("验证失败");
            modelAndView.setViewName("redirect:registerPageEmail");
        }
        return modelAndView;
    }

    /**
     * @param modelAndView
     * @return org.springframework.web.servlet.ModelAndView
     * @mathodName registerPageEmail
     * @Description 邮箱注册页
     * @date 2018/9/9 13:15
     */
    @RequestMapping(value = "/registerPageEmail")
    public ModelAndView registerPageEmail(ModelAndView modelAndView) {
        modelAndView.addObject("item", "emailRegister");
        modelAndView.setViewName("emailRegister");
        return modelAndView;
    }


    /**
     * @param modelAndView, name, result
     * @return org.springframework.web.servlet.ModelAndView
     * @mathodName selectPeopleByName
     * @Description 用户个人信息页
     * @date 2018/8/25 14:42
     */
    @RequestMapping(value = "/u/showPeople1", method = RequestMethod.GET)
    public ModelAndView selectPeopleByName(ModelAndView modelAndView, String name, Result result) {

        userService = server.getUserService();

        logger.info("selectPeopleByName:name===" + name);
        //根据id查询用户信息
        People people = userService.selectByName(name);
        result.setCode(0);
        result.setMsg("用户存在");
        modelAndView.addObject("people", people);
        logger.info("selectPeopleByName:people===" + people.toString());
        modelAndView.addObject("item", "showPeople1");
        modelAndView.setViewName("myView");
        return modelAndView;
    }
}