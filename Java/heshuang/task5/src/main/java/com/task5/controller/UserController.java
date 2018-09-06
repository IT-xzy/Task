package com.task5.controller;

import com.task5.pojo.User;
import com.task5.service.UserService;
import com.task5.until.JWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    JWT jwt;

    @RequestMapping("/login")
    public String Login(){
        return "login";
    }
    @RequestMapping("/register")
    public String Register(){
        return "register";
    }
    @RequestMapping("/exit")
    public String Quit(HttpServletResponse response, HttpSession session){
        String token = jwt.generateToken(null,3600000);
        Cookie cookie = new Cookie("token",token);
        response.addCookie(cookie);
        cookie.setMaxAge(0);
        Cookie cookieSId = new Cookie("JSESSIONID",session.getId());
        response.addCookie(cookieSId);
        cookieSId.setMaxAge(0);
        session.removeAttribute("username");
        return "redirect:/home";
    }
    @RequestMapping(value = "/loginResult")
    public String Login(User user, Model model,HttpServletResponse response,HttpSession session) throws Exception {
        String message = userService.login(user);
        if (message.equals("true")) {
            String token = jwt.generateToken(user.getUserName(),3600000);
            session.setAttribute("username",user.getUserName()+"欢迎您登陆！！");
            System.out.println(token);
            Cookie cookie = new Cookie("token",token);
            cookie.setMaxAge(5*60);
            response.addCookie(cookie);
            Cookie cookieSId = new Cookie("JSESSIONID",session.getId());
            cookieSId.setMaxAge(5*60);
            response.addCookie(cookieSId);
            System.out.println(cookie);
            return "redirect:/home";
        } else {
            model.addAttribute("message", message);
            return "login";
        }
    }

    @RequestMapping(value = "/registerResult", method = RequestMethod.POST)
    public String Register(User user, Model model) throws Exception {
        String message = userService.register(user);
        if (message.equals("true")) {
            model.addAttribute("message", "注册成功，请登录:");
            return "login";
        } else {
            model.addAttribute("message", message);
            return "register";
        }
    }
}
