package com.controller;

import com.exception.MyException;
import com.getService.ServiceFactory;
import com.pojo.User;
import com.service.UserDaoService;
import com.tools.JwtUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.NoSuchAlgorithmException;

@Controller
public class LoginController {
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Autowired
    private ServiceFactory serviceFactory;
    private Logger logger = Logger.getLogger(LoginController.class.getName());

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
        String username = (String) request.getSession().getAttribute("username");
        try {
            model.addAttribute("user", serviceFactory.getUserDaoService().getUser(username));
        } catch (MyException e) {
            logger.error(e.getMessage());
            model.addAttribute("message", "未能获取用户信息");
        }
        return "personalInformation";
    }

    @RequestMapping(value = "/loginResult")
    public String Login(User user, Model model, HttpServletRequest request, HttpServletResponse response) {
        try {
            boolean flag = serviceFactory.getUserDaoService().login(user);
            if (flag) {
                String token = jwtUtil.generateToken(user.getUsername(), 3600000);
                Cookie cookie = new Cookie("token", token);
                cookie.setMaxAge(3600);
                response.addCookie(cookie);
                redisTemplate.opsForValue().set(user.getUsername() + "token", token);
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
            boolean flag = serviceFactory.getUserDaoService().register(user);
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
    public String cancellation(HttpServletResponse response) {
        String token = jwtUtil.generateToken(null, 0);
        Cookie cookie = new Cookie("token", token);
        cookie.setMaxAge(3600);
        response.addCookie(cookie);
        return "redirect:/homePage";
    }
}
