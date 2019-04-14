package com.ptteng.controller;


import com.ptteng.DESUtil;
import com.ptteng.MD5Util;
import com.ptteng.entity.User;
import com.ptteng.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @ClassName UserControllerTest
 * @Description TODO
 * @Author 孙若飞
 * @Date 2019/2/20  20:59
 * @Version 1.0
 **/


@Controller
public class UserControllerTest {
    @Autowired
    UserService userService;
    Logger logger = Logger.getLogger(UserControllerTest.class);

    @RequestMapping(value = "/p/register", method = RequestMethod.GET)
    public String register() {
        return "/one/registerPage";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String insert(User user, HttpServletResponse response) throws UnsupportedEncodingException {
        logger.info("user========================" + user);
        //对传进来的参数进行判空
        if (!ObjectUtils.isEmpty(user.getName())
                && !ObjectUtils.isEmpty(user.getPassword())) {

            //注册时,先根据用户名查,如果查不出,说明数据库里没有这条数据则插入,否则返回注册页面
            List<User> userName = userService.selectByName(user.getName());
            logger.info("userName====================" + userName);
            if (ObjectUtils.isEmpty(userName)) {
                //插入时,使用MD5给密码加密再加盐
                user.setPassword(MD5Util.MD5(user.getPassword()) + user.getId());
                logger.info("用户名和加密后的密码=================" + user);
                int row = userService.insert(user);
                logger.info("是否插入================" + row);
                logger.info("userId===============" + user.getId());
                User dbUser = userService.selectByCondition(user.getName(), user.getPassword());
                //发一个token
                String token = DESUtil.encrypt(System.currentTimeMillis() + "|" + user.getName() + "|" + dbUser.getId());
                logger.info("token========" + token);
                Cookie cookie = new Cookie("token", token);
                cookie.setMaxAge(30 * 60);
                logger.info("tokenName=========" + cookie.getName());
                logger.info("tokenValue============" + cookie.getValue());
                response.addCookie(cookie);
                logger.info("看看保存了没有");
                return "home";
            }
            logger.info("用户名已存在=================");
            return "redirect:/p/register";

        }
        logger.info("用户名密码为空================");
        return "redirect:/p/register";
    }

    @RequestMapping(value = "/p/login", method = RequestMethod.GET)
    public String loginOk() {
        return "one/loginPage";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(User user, HttpServletResponse response) throws UnsupportedEncodingException {
        //先给传入的参数判空
        if (!ObjectUtils.isEmpty(user.getName())
                && !ObjectUtils.isEmpty(user.getPassword())) {
            //密码加密加盐,然后用密码和用户名与数据库里的数据对比,也就是查找
            user.setPassword(MD5Util.MD5(user.getPassword()) + user.getId());
            User dbUser = userService.selectByCondition(user.getName(), user.getPassword());
            if (!ObjectUtils.isEmpty(dbUser)) {
                logger.info("查出的数据==============" + dbUser);


                //发一个token,token由用户名,id,登录时间组成
                //DES加密
                String token = DESUtil.encrypt(System.currentTimeMillis() + "|" + user.getName() + "|" + dbUser.getId());
                logger.info("token=============" + token);
                Cookie cookie = new Cookie("token", token);
                cookie.setMaxAge(30 * 60);
                logger.info("tokenName=========" + cookie.getName());
                logger.info("tokenValue============" + cookie.getValue());
                response.addCookie(cookie);
                logger.info("看看保存了没有");


                return "home";

            } else {
                logger.info("无此用户,去注册============");
                return "one/registerPage";
            }

        }
        logger.info("输入了空数据啊==================");
        return "one/loginPage";
    }


    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletResponse response, HttpServletRequest Request) {


        //创建一个cookie对象,得到cookie
        Cookie[] cookies = Request.getCookies();
        //先取出cookie
        for (Cookie cookie : cookies) {
            //如果存在name为token的cookie,则取出并修改token的时效为0
            if (cookie.getName().equals("token")) {
                cookie.setMaxAge(0);
                logger.info("被删除的token是" + cookie.getName());
                response.addCookie(cookie);


                return "home";
            }
        }
        return "home";
    }


}
