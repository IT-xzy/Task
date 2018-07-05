package com.ptteng.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping(value = "/logout")
public class LogoutController {
    private static Logger logger = Logger.getLogger(LogoutController.class);
    @RequestMapping(value = "/logout" ,method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String result = "";
        Cookie[] cookies = request.getCookies();
        String message="";
        for (Cookie cookie :cookies) {
            if (cookie.getName().equals("test")){
                cookie.setPath("/");
                cookie.setMaxAge(0);
                response.addCookie(cookie);
                logger.info(cookie.getName() + "，cookie值："+cookie.getValue() +"，cookie时间："+cookie.getMaxAge());
                message="退出成功!";
                request.setAttribute("message", message);
                /**
                 * /result= "redirect:/home1";
                 * 使用redirect重定向到页面时，message找不到了，但是使用forward可以接收到message。
                 */
                result= "forward:/home1";
            }else {
                message="没有检测到用户！";
                request.setAttribute("message", message);
                //如果写redirect:home1,则地址栏路径为，/logout/home1。表明重定向到当前的controller中。
                result="forward:/home1";
            }
        }

        return result;
    }
}
