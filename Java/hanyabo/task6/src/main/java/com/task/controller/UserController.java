package com.task.controller;

import com.task.entity.User;
import com.task.entity.UserToken;
import com.task.service.UserService;
import com.task.util.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Enumeration;


@Controller
@RequestMapping("/user")
public class UserController {

//    private static final Logger logger = LoggerFactory.getLogger(UserController.class);


    @Autowired
    private UserService userServivce;

    @RequestMapping(value = "/session",method = RequestMethod.GET)
    public String login(){
        return "login";//跳转到用户登录页面
    }


    //用户登录验证
    @RequestMapping(value = "/session",method = RequestMethod.POST)
    public String checkLogin(User user,HttpServletRequest request,HttpServletResponse response){

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
}
