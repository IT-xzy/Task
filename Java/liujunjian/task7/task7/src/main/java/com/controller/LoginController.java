package com.controller;

import com.exception.MyException;
import com.pojo.User;
import com.service.UserDaoService;
import com.tools.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;

@Controller
public class LoginController {
    private JwtUtil jwtUtil;
    private UserDaoService userDaoService;
    private RedisUtil redisUtil;
    private Logger logger = Logger.getLogger(LoginController.class.getName());

    @Autowired
    public LoginController(JwtUtil jwtUtil, UserDaoService userDaoService, RedisUtil redisUtil) {
        this.jwtUtil = jwtUtil;
        this.userDaoService = userDaoService;
        this.redisUtil = redisUtil;
    }

    @RequestMapping("/login")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/register")
    public String toRegister() {
        return "register";
    }

    @RequestMapping("/personalInformation")
    public String toPersonalInformation(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        try {
            model.addAttribute("user", userDaoService.getUser(username));
        } catch (MyException e) {
            logger.error(e.getMessage());
            model.addAttribute("message", "未能获取用户信息");
        }
        return "personalInformation";
    }

    @RequestMapping(value = "/loginResult")
    public String Login(User user, Model model, HttpServletRequest request, HttpServletResponse response) {
        try {
            boolean flag = userDaoService.login(user);
            if (flag) {
                String token = jwtUtil.generateToken(user.getUsername());
                Cookie cookie = new Cookie("token", token);
                cookie.setMaxAge(3600);
                response.addCookie(cookie);
                redisUtil.setString(user.getUsername() + "token", token);
                request.getSession().setAttribute("username", user.getUsername());
//                model.addAttribute("username", user.getUsername());
                return "redirect:/homePage";
            } else {
                model.addAttribute("message", "用户名和密码不匹配");
                return "login";
            }
        } catch (MyException e) {
            logger.error(e.getMessage());
        } catch (NoSuchAlgorithmException e) {
            logger.error("加密出错");
        }
        return "login";
    }

    @RequestMapping(value = "/registerResult", method = RequestMethod.POST)
    public String Register(User user, Model model) {
        try {
            boolean flag = userDaoService.register(user);
            if (flag) {
                model.addAttribute("message", "注册成功，请登录");
                return "login";
            }
        } catch (MyException e) {
            model.addAttribute("message", e.getMessage());
            logger.error(e.getMessage());
            return "register";
        } catch (NoSuchAlgorithmException e) {
            logger.error("加密出错");
        }
        return "register";
    }

    @RequestMapping("/cancellation")
    public String cancellation(HttpServletRequest request) {
        String username = (String) request.getSession().getAttribute("username");
        redisUtil.deleteObject(username + "token");
        return "redirect:/homePage";
    }
}
