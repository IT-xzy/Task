package com.suger.controller;

import com.suger.pojo.User;
import com.suger.service.RMIService;
import com.suger.service.UploadService;
import com.suger.service.UserService;
import com.suger.util.*;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.*;


/**
 * @author suger
 * @date 2018/11/20 14:53
 *
 * 用户的注册，登录与注销，验证
 */

@Controller
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private RMIService rmiService;
    public UserService userService;
    public UploadService uploadService;


    /**
     * 跳转个人主页
     * @param name 获取用户信息
     * @param request
     * @return  在个人主页展示
     */

    @RequestMapping(value = "/u/user/{name}")
    public ModelAndView userPage(@PathVariable(value = "name") String name,HttpServletRequest request){

        ModelAndView mav = new ModelAndView("userPage");
        userService = rmiService.getUserService();

        System.out.println("userService = " + userService);
        User userInfo = userService.getUserByName(name);
        mav.addObject("user",userInfo);
        mav.addObject("img",userInfo.getImg());
        return mav;
    }

    // 跳转登录
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(HttpServletRequest request, HttpServletResponse response){
        return "login";
    }

    // 准备登陆
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(String name, String pwd,Model model,HttpServletRequest request, HttpServletResponse response,HttpSession session){


        logger.info("登录信息,name:{},pwd:{}",name,pwd);

        User userInfo = null;

        userService = rmiService.getUserService();
        System.out.println("userService = " + userService);

        // 输入的是邮箱
        if(name.contains("@")){
            logger.info("邮箱登录：{}",name);
            userInfo = userService.getUserByEmail(name);
            logger.info("-------1------------userInfo：" + userInfo);
        }else
        // 输入的是11位手机号
        if(name.length()==11&&StringUtils.isNumeric(name)){
            logger.info("手机号登录：{}",name);
            userInfo = userService.getUserByphone(name);
            logger.info("--------2---------------------userInfo：" + userInfo);

        }else if(!name.isEmpty()){
            logger.info("用户名登录：{}",name);
            userInfo = userService.getUserByName(name);
            logger.info("---------3---------------------userInfo：" + userInfo);
        }

        logger.info("userInfo：" + userInfo);

        if(userInfo == null){
            model.addAttribute("message","用户不存在");
            logger.info("账号不存在");
            return "login";
        }
        // 参数检验通过,开始登陆
        // 采用 UUID 为盐值
        String salt = userInfo.getSalt();
        logger.info("盐值："+salt);
        // md5 加密
        String password = MD5Utils.md5(pwd+salt);
        logger.info("加盐后的密码："+password);
        logger.info("数据库的密码："+userInfo.getPwd());


        // 判空以及验证密码
        if(userInfo.getPwd() == null || userInfo.getPwd().isEmpty() || !userInfo.getPwd().equals(password)) {
            model.addAttribute("message","密码输入有误，请重新输入");
            logger.info("密码输入有误，请重新输入");
            return "login";
        }else{
            logger.info(name+":登录成功");
            // 实例化 jwt ,可以设置自己的加密密码---字符串形式
            JwtUtils jwtUtils = new JwtUtils();

            // 用户名加密后 和时间戳一起写入token
            String username = DesUtils.encode(userInfo.getName());
            // 8小时后token过期
            long maxAge = 8*60L * 60L * 1000L;
            String token = jwtUtils.getToken(username, maxAge);

            Cookie cookie = new Cookie("token", token);
            logger.info("token = " + token);

            // 1天过期
            cookie.setMaxAge(24*60*60);
            cookie.setPath("/");
            response.addCookie(cookie);

            session.setAttribute("name",userInfo.getName());
            session.setAttribute("img",userInfo.getImg());
            // 60分钟
            session.setMaxInactiveInterval(24*60*60);
            return "redirect:/home";
        }

    }


    /**
     * 发送邮箱验证码
     * @param email
     * @return  发送成功（状态为0），发送失败(状态为1），默认发送失败
     * @throws IOException
     */

    @ResponseBody
    @RequestMapping(value = "/user/email",method = RequestMethod.POST,produces = "text/xml;charset=UTF-8")
    public String emailCode(String email) throws IOException {

        logger.info("使用邮箱{}注册：",email);
        userService = rmiService.getUserService();
        System.out.println("userService = " + userService);

        //生成随机验证码
        //String msgCode = DataUtils.getNumber(6);
        // 为测试方便 验证码固定为111111
        String msgCode = "111111";
        logger.info("验证码："+msgCode);
        int status = userService.sendEmai(email,msgCode);
        logger.info("email-status:{}",status);
        String message = "请稍后再试";
        if(status == 0){
            message = "验证码发送成功";
        }
        return message;
    }


    /**
     * 发送手机验证码
     * @param phone
     * @return  0：发送成功 2:发送过于频繁 3：超过每天最大次数 1：其他
     */

    @ResponseBody
    @RequestMapping(value = "/user/phone",method = RequestMethod.POST,produces = "text/xml;charset=UTF-8")
    public String phoneCode(String phone) {

        logger.info("使用手机号:{}注册",phone);
        // String msgCode = DataUtils.getNumber(6);
        // 为测试方便 验证码固定为111111
        String msgCode = "111111";
        logger.info("验证码："+msgCode);
        userService = rmiService.getUserService();
        System.out.println("userService = " + userService);

        int status = userService.sendPhone(phone,msgCode);
        logger.info("phone-status:{}",status);
        String message = null;
        if(status == 0){
            message = "验证码发送成功";
        }
        if(status == 1){
            message = "请稍后再试";
        }
        if(status == 2){
            message = "发送过于频繁";
        }
        if(status == 3){
            message = "超过每天最大次数";
        }
        logger.info("手机验证码的信息:{}",message);
        return message;
    }



    // 跳转注册页面
    @RequestMapping(value = "/reg",method = RequestMethod.GET)
    public String goReg(){
        return "/reg";
    }

    // 进入注册页面
    @RequestMapping(value = "/reg/phone",method = RequestMethod.POST)
    public ModelAndView regPhone(User user,String msgCode, ModelAndView mav,HttpServletRequest request, HttpServletResponse response){

        String name = user.getName();
        String password = user.getPwd();
        String phone = user.getPhone();
        logger.info("name:{},phone:{},msgCode(验证码）:{}",name,phone,msgCode);

        userService = rmiService.getUserService();
        System.out.println("userService = " + userService);


        // 此处写参数检验
        mav.setViewName("/reg");
        if(StringUtils.isBlank(name)|| StringUtils.isBlank(password)|| StringUtils.isBlank(phone)){
            mav.addObject("message","注册信息不能为空");
            mav.addObject("code",1);
            return mav;
        }

        if(userService.getUserByName(name)!=null){
            mav.addObject("message","用户名已经存在");
            mav.addObject("code",2);
            return mav;
        }
        if(userService.getUserByphone(phone)!=null){
            mav.addObject("message","手机号已经被注册");
            mav.addObject("code",2);
            return mav;
        }
        logger.info("注册信息检查："+mav.getModel());


        // 用户信息检查完毕，可以注册
        if(msgCode==null){
            mav.addObject("message","请输入验证码");
            return mav;
        }
        // 检验手机号的验证码，msgcode 是用户输入的验证码
        if(userService.checkPhoneCode(phone,msgCode)==0){
            // 手机号的验证码 检验成功，进行注册
            // 密码加密
            String salt = UUIDUtils.getUUID();
            logger.info("盐值："+salt);
            user.setSalt(salt);
            password = MD5Utils.md5(user.getPwd()+salt);
            user.setPwd(password);

            userService.insertUser(user);
            mav.setViewName("redirect:/login");
            return mav;
        }else{
            mav.addObject("message","验证码错误");
            return mav;
        }
    }

    @RequestMapping(value = "/reg/email",method = RequestMethod.POST)
    public ModelAndView regEmail(User user, ModelAndView mav,String msgCode,HttpServletRequest request, HttpServletResponse response){

        String name = user.getName();
        String password = user.getPwd();
        String email =user.getEmail();

        logger.info("name:{},email:{},msgCode(验证码）:{}",name,email,msgCode);

        userService = rmiService.getUserService();
        System.out.println("userService = " + userService);


        // 判定输入用户名，密码，邮箱，是否为空，若其中一项为空，则返回注册页面
        // 此处写参数检验
        if(StringUtils.isBlank(name)|| StringUtils.isBlank(password)|| StringUtils.isBlank(email)){
            mav.addObject("message","注册信息不能为空");
            mav.addObject("code",1);
            mav.setViewName("/reg");
            return mav;
        }
        // 检验用户名以及邮箱的唯一性，若不唯一,说明已经注册过，则跳转登录页面
        if(userService.getUserByName(name)!=null || userService.getUserByEmail(email) != null){
            logger.info("用户已经存在！");
            mav.addObject("message","用户名已存在,");
            mav.addObject("code",2);
            mav.setViewName("redirect:/login");
            return mav;
        }

        // 注意默认 0 是正确的，这个之前写反了，
        if(userService.checkEmailCode(email,msgCode)==1){
            mav.addObject("message","验证码错误");
            mav.addObject("code",3);
            mav.setViewName("/reg");
            return mav;
        }

        // 检验通过，开始注册
        String salt = UUIDUtils.getUUID();
        logger.info("盐值："+salt);
        user.setSalt(salt);
        password = MD5Utils.md5(user.getPwd()+salt);
        user.setPwd(password);
        logger.info(user.toString());


        userService.insertUser(user);
        mav.addObject("message","注册成功");
        mav.setViewName("redirect:/login");
        return mav;
    }


    @RequestMapping("/u/upload/{name}")
    @ResponseBody
    public String upload(MultipartFile multipartFile, @PathVariable String name, HttpServletRequest request,HttpSession session)throws Exception {

        logger.info("上传修改用户的头像信息");

        uploadService = rmiService.getUplaodService();
        userService =rmiService.getUserService();
        System.out.println("userService = " + userService);
        String imgURL = uploadService.aliyunUploadFile(multipartFile);
        logger.info("图片的对象存储链接地址：{}", imgURL);

        userService = rmiService.getUserService();
        User user = userService.getUserByName(name);
        user.setImg(imgURL);
        logger.info("user:{}", user.toString());
        if (imgURL != null && imgURL.length() > 0) {
            userService.updateUser(user);
            // 更新session值
            session.setAttribute("img",user.getImg());
        }
        return imgURL;
    }


    //-----------------注销---------------------------
    @RequestMapping(value = "/u/logout",method = RequestMethod.GET)
    public String logout(HttpSession session,HttpServletRequest request, HttpServletResponse response){
        // 删除session
        session.invalidate();
        logger.info("注销------");

        Cookie[] cookies = request.getCookies();
        // setMaxAge(0)------删除Cookie失效----------默认 setMaxAge(-1) ,关闭浏览器删除Cookie
        if(cookies==null){
            return  "redirect:/home";
        }
        for (Cookie cookie : cookies) {
            if ("token".equals(cookie.getName()) || "JSESSIONID".equals(cookie.getName())) {
                cookie.setValue(null);
                cookie.setMaxAge(0);
                cookie.setPath("/");
                response.addCookie(cookie);
                logger.info("清除token和session");
            }
        }
        logger.info("退出登录");
        return  "redirect:/home";
    }
}
