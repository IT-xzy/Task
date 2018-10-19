package com.controller;/*
 * @ClassName:LoginController
 * @Description: jsp
 * @Author qiao
 * @Date 2018/8/1 10:03
 **/

import com.model.People;
import com.service.UserService;
import com.util.DESUtil;
import com.util.MD5Util;
import com.util.Result;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import org.apache.log4j.Logger;

@Controller
@Component

public class LoginController {
    private static Logger logger = Logger.getLogger("LoginController.class");
    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

    /**
     * @param {name}、{password}
     * @return
     * @mathodName login
     * @Description 登录
     * @date 2018/7/31 21:52
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpServletResponse response, People people, DESUtil desUtil) throws UnsupportedEncodingException {

        logger.info("login:参数" + request.getParameter("passward") + request.getParameter("name"));

        //MD5加密加盐
        people.setPassword(DigestUtils.md5Hex(people.getPassword()) + "abc");
        //登录验证userService.login方法
        People people1 = userService.login(people.getName(), people.getPassword());

        logger.info("验证结果" + people1);
        //登录时间
        people.setUpdateTime(System.currentTimeMillis());
        //DES加密
        String str1 = desUtil.encryptFromLong(people.getUpdateTime());
        String str2 = desUtil.encryptFromLong(people.getId());
        //token：登录时间、用户Id、用户姓名加密组成
        String name = desUtil.encrypt(people.getName());
        String token = desUtil.encrypt(str1 + "|" + name + "|" + str2);
        if (people1 != null) {

            logger.info("登录成功");
            //添加cookie
            Cookie namecookie = new Cookie("name", name);// 新建一个Cookie对象
            Cookie tokencookie = new Cookie("token", token);
            namecookie.setMaxAge(30 * 60);// 设置为30min，生命周期
            tokencookie.setMaxAge(30 * 60);
            namecookie.setPath("/");//设置Cookie的使用路径
            tokencookie.setPath("/");
            response.addCookie(namecookie);// 保存cookie到客户端
            response.addCookie(tokencookie);
            request.getSession().setAttribute("name", request.getParameter("name"));
            return "forward:/people";
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
                break;
            }
        }
        return "redirect:/people";
    }

    /**
     * @param {name} {password}
     * @return
     * @mathodName register
     * @Description 注册
     * @date 2018/8/3 21:13
     */
    @RequestMapping(value = "/people5IndexController", method = RequestMethod.POST)
    public ModelAndView register(People people, ModelAndView modelAndView, HttpServletRequest request) {

        logger.info("register参数：name、password" + people.toString());
        logger.info(request.getParameter("password1"));

        //判断姓名密码非空
        if (people.getName().equals("") | people.getPassword().equals("") | request.getParameter("password1").equals("")) {
            modelAndView.addObject("message", "姓名和密码不能为空");
            modelAndView.setViewName("register");
        } else {
            if (request.getParameter("password").equals(request.getParameter("password1"))) {
                logger.info("register");
                people.setCreatTime(System.currentTimeMillis());
                try {
                    //判断姓名存在
                    People people1 = userService.selectByName(people.getName());
                    logger.info("数据库信息" + people1.toString());
                    String name = people1.getName();
                    modelAndView.addObject("message", "已注册");
                    modelAndView.addObject("name", name);
                    modelAndView.setViewName("register");
                } catch (NullPointerException e) {
                    //MD5加密加盐，加了固定的字符串
                    people.setPassword(DigestUtils.md5Hex(people.getPassword()) + "abc");
                    userService.addUser(people);
                    modelAndView.addObject("message", "注册成功,请登录");
                    modelAndView.setViewName("login");
                }
            } else {
                modelAndView.addObject("message", "两次密码输入不一致");
                modelAndView.setViewName("register");
            }
        }
        return modelAndView;
    }

    /**
     * @param
     * @return
     * @mathodName registerPage
     * @Description 注册页
     * @date 2018/8/10 22:31
     */
    @RequestMapping(value = "/registerPage")
    public ModelAndView registerPage(ModelAndView modelAndView) {
        modelAndView.setViewName("register");
        return modelAndView;
    }
/**
 * @mathodName updatePeople
 * @Description 更新用户接口
 * @date 2018/8/21 11:42
 * @param [modelAndView, people, result]
 * @return org.springframework.web.servlet.ModelAndView
 */
    @RequestMapping(value = "/people", method = RequestMethod.PUT)
    public ModelAndView updatePeople(ModelAndView modelAndView, People people, Result result) {

        logger.info("updatePeople:People" + people.toString());
        people.setUpdateTime(System.currentTimeMillis());
        int i = userService.updatePeople(people);
        if (i == 0) {
            result.setMsg("更新失败");
        } else {
            result.setMsg("更新成功");
        }
        modelAndView.addObject("result", result);
        modelAndView.setViewName("updatePeople");
        return modelAndView;
    }


}