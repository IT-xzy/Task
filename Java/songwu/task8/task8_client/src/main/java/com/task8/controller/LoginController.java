package com.task8.controller;

import com.task8.pojo.Person;
import com.task8.service.LoginService;
import com.task8.util.CookieUtil;
import com.task8.util.JwtUtil2;
import com.task8.util.RmiServerUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Create by SongWu on 2018/7/5
 */

@Controller
public class LoginController {
    Logger logger = Logger.getLogger(LoginController.class);

    //@Autowired
//public     LoginService loginService;


    //    登录
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Person person, Model model, HttpServletResponse response, HttpServletRequest request) {
        String token = null;
//       rmi
        RmiServerUtil rmiServerUtil = new RmiServerUtil();

        LoginService loginService = rmiServerUtil.getLoginService();
        String Message = loginService.login(person);
        if (Message.equals("true")) {

            try {

                token = JwtUtil2.getToken(person.getUsername());
            } catch (Exception e) {
                e.printStackTrace();
            }


            logger.info("token值：" + token);
            response.addCookie(CookieUtil.getCookie("tokens", token));

            HttpSession session = request.getSession();
            logger.info("sessionId值：" + session.getId());
            session.setAttribute("tokens", token);
            session.setAttribute("username", person.getUsername());
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
//rmi
        RmiServerUtil rmiServerUtil = new RmiServerUtil();

        LoginService loginService = rmiServerUtil.getLoginService();

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

//        rmi
        RmiServerUtil rmiServerUtil = new RmiServerUtil();

        LoginService loginService = rmiServerUtil.getLoginService();


        String Message = loginService.reset(person, password2, repassword2);

        model.addAttribute("loginMessage", Message);

        return "loginMessage";
    }


    @RequestMapping(value = "/off")
    public void off(HttpServletRequest request, HttpServletResponse response) {
        logger.info("token:" + CookieUtil.getCookieByName(request, "tokens"));
//        rmi

        Cookie token = CookieUtil.getCookieByName(request, "tokens");
        token.setValue(null);
        token.setMaxAge(0);
        token.setPath("/");
        response.addCookie(token);
        try {
            //        response.sendRedirect("/logout");
            request.getRequestDispatcher("/logout").forward(request, response);
            logger.info("注销成功");
        } catch (Exception e) {
            logger.info("出现异常情况");


        }


    }
}
