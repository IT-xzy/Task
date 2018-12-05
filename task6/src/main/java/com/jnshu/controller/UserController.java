package com.jnshu.controller;

import com.jnshu.entity.User;
import com.jnshu.myutils.DESUtil;
import com.jnshu.myutils.MD5Util;
import com.jnshu.service.Login;
import com.jnshu.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;


@Controller
public class UserController {
    Logger logger = Logger.getLogger(UserController.class);
    @Autowired
    UserService userService;
    @Autowired
    Login login;
    //如果一个路径请求只是为了转发，不做任何业务处理，这时可以在Springmvc.xml中配置一下
    @RequestMapping(value = "register", method = RequestMethod.GET)
    public ModelAndView registerPage(ModelAndView modelAndView){
       modelAndView.setViewName("register");
        return modelAndView;
    }
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ModelAndView register(User user, ModelAndView modelAndView) {
        logger.info("register=======\n"+"用户名和密码分别是："+user.toString());
        //使用DES加密工具对密码进行加盐处理
        logger.info(user.getUsername()+user.getPassword());
        user.setPassword(MD5Util.md5(user.getUsername()+user.getPassword()));
        Boolean success = userService.register(user);
        String jspName = "registerSuccess";
//        String message = "";
        try {
            if(!success){
               modelAndView.addObject("message","用户名已存在" );
                //modelAndView.addObject("code", -600);
               //jspName = "reRegister";
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
            modelAndView.addObject("code", -601);
        }
       modelAndView.setViewName(jspName);
        return modelAndView;
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public ModelAndView loginPage(ModelAndView modelAndView){
        modelAndView.setViewName("login");
        return modelAndView;
    }
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ModelAndView login(HttpServletResponse response, User user, ModelAndView modelAndView , DESUtil desUtil) throws UnsupportedEncodingException {
        logger.info("login======"+user.toString());
        String view = login.login(user,desUtil,response);

       /* user.setPassword(MD5Util.md5(user.getUsername()+user.getPassword()));
        Boolean success = userService.login(user);
        logger.info("login======"+success);
        long loginTime =  System.currentTimeMillis();
        //DES加密
        String view = " ";
        try{
            if (success ==null) {
                //modelAndView.addObject("code", -601);
                    logger.info("用户名或密码错误，请重新输入");
                view = "login";
            } else if(success) {
                logger.info("登陆成功");
               // modelAndView.addObject("code", -600);
                Cookie cookie = new Cookie("name", user.getUsername());//新建一个cookie对象
                cookie.setPath("/");//设置cookie的使用路径；
                cookie.setMaxAge(20*60);//设置cookie的生命周期为30min
                response.addCookie(cookie);//保存cookie到客户端
                view = "redirect:/u/task-93";
                logger.info("cookie.getValue===="+cookie.getValue());
                logger.info("cookie.getName====="+cookie.getName());
            }else{
                logger.info("登陆失败");
            }
        }catch(RuntimeException e){
            e.printStackTrace();
            modelAndView.addObject("code", -601);
        }*/
        modelAndView.setViewName(view);
        return modelAndView;
    }
    @RequestMapping(value = "logout",method = RequestMethod.GET)
    public ModelAndView logout(HttpServletResponse response, HttpServletRequest request ,ModelAndView modelAndView){
       logger.info("logout==========");
        Cookie[] cookies = request.getCookies();
        if(cookies.length != 0){
            logger.info("开始清理cookie..............");
            for(Cookie cookie:cookies){
                logger.info("cookie.getValue()===="+cookie.getValue());
                if(cookie.getName().equals("name")){
                    logger.info("cookie中有已登陆的用户");
                    cookie.setValue(null);
                    cookie.setMaxAge(0);//删除cookie就是将其生命周期设为0
                    cookie.setPath("/");
                    response.addCookie(cookie);
                    logger.info("cookie已经成功删除");
                }
            }
        }
        modelAndView.setViewName("redirect:/task-91");
        return modelAndView;
    }
}