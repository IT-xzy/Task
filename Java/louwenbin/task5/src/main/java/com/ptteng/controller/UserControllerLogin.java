package com.ptteng.controller;


import com.ptteng.entity.UserLogin;
import com.ptteng.service.Impl.UserServiceImplLogin;
import com.ptteng.utils.encrypt.DesUtil;
import com.ptteng.utils.interceptor.LoginInterceptor;
import com.ptteng.utils.md5.MD5Util;
import net.rubyeye.xmemcached.MemcachedClient;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.Charset;
import java.util.Random;

@Controller
public class UserControllerLogin {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
    @Resource
    private UserServiceImplLogin userServiceImplLogin;
    private static final String SKEY = "12345678";
    private static final Charset CHARSET = Charset.forName("gb2312");

    @RequestMapping(value = "/regi", method = RequestMethod.GET)
    public String toInsertUser() {
        return "regi";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String insertUser(UserLogin user, Model model) {
        MD5Util md5Util = new MD5Util();
        String name = user.getName();
        String password = user.getPassword();
        UserLogin userDB = userServiceImplLogin.selectUserLogin(name);
        if (userDB != null) {
            model.addAttribute("返回通知", "用户名已存在");
            return "/regi";
        } else if (!("".equals(password))) {
            int salt = (int) ((Math.random() * 9 + 1) * 100000);
            password = MD5Util.MD5(password + salt);
            user.setPassword(password);
            user.setSalt(salt);
            userServiceImplLogin.insertUserLogin(user);
            model.addAttribute("返回通知", "注册成功,请登陆");
            return "/login";
        } else {
            model.addAttribute("返回通知", "密码不能为空");
            return "/regi";
        }
    }

    @RequestMapping(value = "/notice", method = RequestMethod.GET)
    public String notice() {
        return "notice";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model, UserLogin user, HttpServletResponse response) {
        String name = user.getName();
        String password = user.getPassword();
        UserLogin userDB = userServiceImplLogin.selectUserLogin(name);
        //加密
        String nameDes = name + "|" + System.currentTimeMillis();
        String nameDesResult = DesUtil.encrypt(nameDes, CHARSET, SKEY);
        logger.info("password+userDB.getSalt():...." + MD5Util.MD5(password + userDB.getSalt()));
        logger.info("userDB.getPassword():....." + userDB.getPassword());
        if (userDB != null) {
            if (MD5Util.MD5(password + userDB.getSalt()).equals(userDB.getPassword())) {
                //创建cookie
                Cookie nameCookie = new Cookie("name", nameDesResult);
                nameCookie.setMaxAge(60 * 60 * 24);
                response.addCookie(nameCookie);
                return "redirect:/u/t11";
            } else {
                model.addAttribute("返回通知", "账号或密码错误");
                return "/login";
            }
        } else {
            model.addAttribute("返回通知", "用户名不存在");
            return "/login";
        }
    }
}
