package com.task7.controller;

import com.task7.pojo.Person;
import com.task7.service.LoginService;
import com.task7.util.CookieUtil;
import com.task7.util.JwtUtil2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Create by SongWu on 2018/7/5
 */

@Controller
public class LoginController {
    @Autowired
    LoginService loginService;

    //    登录
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Person person, Model model, HttpServletResponse response, HttpServletRequest request) {
        String token = null;
        String Message = loginService.login(person);
        if (Message.equals("true")) {

            try {

                token = JwtUtil2.getToken(person.getUsername());
            } catch (Exception e) {
                e.printStackTrace();
            }


            System.out.println("token值：" + token);
            response.addCookie(CookieUtil.getCookie("tokens", token));

            HttpSession session = request.getSession();
            System.out.println("sessionId值：" + session.getId());
            session.setAttribute("tokens", token);
            session.setAttribute("username",person.getUsername());
            session.setMaxInactiveInterval(24 * 60 * 60);
            return "redirect:u/profession";

        }

        model.addAttribute("loginMessage", Message);
        return "loginMessage";

    }


    //返回登录页面
    @RequestMapping(value = "/logout")
    public String logout() {
        return "login";
    }

    //跳转到注册页面
    @RequestMapping(value = "/loginFormShow")
    public String logFormShow() {
        return "loginForm";
    }

    //注册后信息
    @RequestMapping(value = "/loginForm", method = RequestMethod.POST)
    public String loginForm(Person person, Model model) {
        String Message = loginService.loginForm(person);
        model.addAttribute("loginMessage", Message);
        return "loginMessage";

    }

    //        跳转到重置页面
    @RequestMapping(value = "/loginReset")
    public String loginReset() {
        return "loginReset";
    }

    //重置后信息
    @RequestMapping(value = "/reset")
    public String reset(Person person, @RequestParam(name = "password2") String password2, @RequestParam String repassword2, Model model) {
        System.out.println("person:" + person + "password2:" + password2);
        String Message = loginService.reset(person, password2, repassword2);

        model.addAttribute("loginMessage", Message);

        return "loginMessage";
    }

    //    注销登录
    @RequestMapping(value = "/off")
    public void off(HttpServletRequest request, HttpServletResponse response) {
        String Message = loginService.off(request, response);


        try {
//            response.sendRedirect("/logout");
            request.getRequestDispatcher("/logout").forward(request, response);
            System.out.println(Message);

        } catch (Exception e) {
            System.out.println("出现异常情况");
        }


    }


}
