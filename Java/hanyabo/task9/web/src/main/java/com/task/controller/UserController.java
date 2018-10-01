package com.task.controller;

import com.task.entity.User;
import com.task.entity.UserToken;
import com.task.service.UserService;
import com.task.util.*;
import org.apache.http.HttpException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Enumeration;


@Controller
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    SmsUtil smsUtil;

//    @Autowired
//    private UserService userServivce;

    @RequestMapping(value = "/session",method = RequestMethod.GET)
    public String login(){
        return "login";//跳转到用户登录页面
    }


    private UserService getUserServivce() throws RemoteException, NotBoundException, MalformedURLException {
        return new TuscanyServiceUtil().getUserService();
    }


    //用户登录验证
    @RequestMapping(value = "/session",method = RequestMethod.POST)
    public String checkLogin(User user,HttpServletRequest request,HttpServletResponse response) throws RemoteException, NotBoundException, MalformedURLException {

        UserService userServivce = getUserServivce();
        //调用service方法
        user = userServivce.checkLogin(user.getUsername(), user.getPassword());

        //若有user则添加到model里并且跳转到成功页面
        if(user != null){

            //设置session
            request.getSession().setAttribute("user", user);

            //设置cookie
            UserToken userToken = new UserToken();
            userToken.setName(user.getUsername());
            userToken.setPswd(user.getPassword());

            String token = JwtUtil.sign(userToken, 60L* 1000L* 30L);
            Cookie cookie = new Cookie("token",token);
            cookie.setMaxAge(30 * 60);// 设置为30min
            cookie.setPath("/");
            response.addCookie(cookie);

            return "welcome";
        }
        return "login";
    }

    //注销方法
    @RequestMapping(value = "/session",method = RequestMethod.DELETE)
    public ModelAndView outLogin(HttpServletRequest request, HttpServletResponse response){

        //清除session
        Enumeration em = request.getSession().getAttributeNames();
        while(em.hasMoreElements()){
            request.getSession().removeAttribute(em.nextElement().toString());
        }
        HttpSession session = request.getSession();
        session.invalidate();

        //清除cookie
        Cookie[] cookies = request.getCookies();
        if (null==cookies) {
//            logger.info("there is no cookie");
        } else {

            for(Cookie cookie : cookies){

//                logger.info("delete cookie name:"+cookie.getName());
//
//                if(cookie.getName().equals("token")) {
//                    logger.info("delete cookie value:" + cookie.getValue());
//                }

                cookie.setValue(null);
                cookie.setMaxAge(0);// 立即销毁cookie
                cookie.setPath("/");

                response.addCookie(cookie);
            }
        }
        ModelAndView mav = new ModelAndView("redirect:/jnshu/welcome");

        return mav;
    }



    @RequestMapping(value = "/phone",method = RequestMethod.GET)
    public String jumpToPhoneAddUser(){

        //页面跳转到手机号注册框页面
        return "signPhone";
    }

    @RequestMapping(value = "/email",method = RequestMethod.GET)
    public String jumpToEmailAddUser(){

        //页面跳转到手机号注册框页面
        return "signEmail";
    }

    @RequestMapping(value = "/insert",method = RequestMethod.PUT)
    public ModelAndView addUser(User user,String checkCode,HttpServletRequest request) throws RemoteException, NotBoundException, MalformedURLException {

        UserService userServivce = getUserServivce();
        HttpSession session = request.getSession();//设置session
        String sessioncode = null;
        String str = user.getPhone();

        int phoneOrEmail = 0;
        if(null != str){
            sessioncode =(String) session.getAttribute(str+"code");
            logger.info("短信验证码:"+sessioncode);
            phoneOrEmail = 1;

        }else {
            str = user.getEmail();
            if(null != str){
                sessioncode =(String) session.getAttribute(str+"code");
                logger.info("邮件验证码:"+sessioncode);
                phoneOrEmail = 2;
            }
        }

        int ret = 0;

        if((checkCode).equals(sessioncode)){//验证码对比相等

            ret = userServivce.checkLoginByUser(user);

            logger.info("userResult" + ret);

        }else{//验证码不相等
            ret = 5;
        }

        ModelAndView mav = new ModelAndView();

        if(0 != ret){//注册异常

            mav.addObject("errCode", ret);
            if(1 == phoneOrEmail){
                mav.setViewName("redirect:/user/phone");

            }else if(2 == phoneOrEmail){
                mav.setViewName("redirect:/user/email");
            }


        }else{//注册正常
            mav.setViewName("redirect:/jnshu/welcome");
            userServivce.addUser(user);

        }

        return mav;
    }


    @RequestMapping(value = "/sms",method = RequestMethod.GET)
    public ModelAndView sendSms(@RequestParam(value="un") String username,
                                @RequestParam(value="ps") String password,
                                @RequestParam(value="ph") String phone,
                                HttpServletRequest request) throws HttpException, IOException, NotBoundException {
        ModelAndView mav = new ModelAndView();
        UserService userServivce = getUserServivce();

        int ret = userServivce.checkUsername(username);

        if(0 == ret){//用户名未被占用

            ret = userServivce.checkPhone(phone);

            if(0 == ret){//手机号未被占用

                String code = RandomUtil.getCode();

                int stat = smsUtil.sendSms(phone, code);

                if(0 == stat){
                    mav.addObject("flag", "短信发送成功");
                    logger.info("短信验证码："+code);
                    HttpSession  session = request.getSession(); //设置session
                    session.setAttribute(phone+"code", code);    //将短信验证码放到session中保存
                    session.setMaxInactiveInterval(60*3); //缓存设置1分钟

                }else {
                    mav.addObject("flag", "短信发送失败");
                }
            }else{
                mav.addObject("flag1", "手机号被占用");
            }
        }else{
            mav.addObject("flag1", "用户名被占用");
        }

        mav.addObject("username", username);
        mav.addObject("password", password);
        mav.addObject("phone", phone);



        mav.setViewName("signPhone");
        return mav;
    }


    @RequestMapping(value = "/maildata",method = RequestMethod.GET)
    public ModelAndView sendEmail(@RequestParam(value="un") String username,
                                @RequestParam(value="ps") String password,
                                @RequestParam(value="em") String email,
                                HttpServletRequest request) throws Throwable {
        UserService userServivce = getUserServivce();

        ModelAndView mav = new ModelAndView();

        int ret = userServivce.checkUsername(username);

        if(0 == ret){//用户名未被占用

            ret = userServivce.checkEmail(email);

            if(0 == ret){//邮箱未被占用

                String code = RandomUtil.getCode();

                logger.info("验证码："+code);

                boolean stat = EmailUtil.sendTo(email, code);

                if(stat){
                    mav.addObject("flag", "邮件发送成功");
                    logger.info("邮件验证码："+code);
                    HttpSession  session = request.getSession(); //设置session
                    session.setAttribute(email+"code", code);    //将短信验证码放到session中保存
                    session.setMaxInactiveInterval(60*3); //缓存设置1分钟

                }else {
                    mav.addObject("flag", "邮件发送失败");
                }
            }else{
                mav.addObject("flag1", "邮箱被占用");
            }
        }else{
            mav.addObject("flag1", "用户名被占用");
        }

        mav.addObject("username", username);
        mav.addObject("password", password);
        mav.addObject("email", email);

        mav.setViewName("signEmail");
        return mav;
    }
}
