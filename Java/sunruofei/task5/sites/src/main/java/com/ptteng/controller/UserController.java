package com.ptteng.controller;


import com.ptteng.DESUtil;
import com.ptteng.MD5Util;
import com.ptteng.entity.User;
import com.ptteng.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.List;


/**
 * @ClassName UserController
 * @Description TODO
 * @Author 孙若飞
 * @Date 2019/2/15  16:11
 * @Version 1.0
 **/
@Controller
public class UserController {
    @Autowired
    UserService userService;
    Logger logger = Logger.getLogger(UserController.class);

    //    访问register,跳到registerPage页面
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "one/registerPage";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String insert(User user, String name) {
        logger.info("新注册用户信息================" + user);
//        通过用户名查找数据,看是否有这条数据
        List<User> users = userService.selectByName(name);
        logger.info("查看数据库里是否有配置的数据================" + users);
//        能查出来这条数据就说明数据库里有这条数据,那么注册失败,否则注册成功,跳转到登录页面
        if (!CollectionUtils.isEmpty(users)) {
            logger.info("用户已存在=============");
            return "redirect:/register";
        } else {
            if (
                    user.getName() != null
                            && user.getName().length() > 0
                            && user.getPassword() != null
                            && user.getPassword().length() > 0) {
//                MD5给密码加密加盐
                user.setPassword(MD5Util.MD5(user.getPassword()) + user.getId());

                logger.info("注册用户的信息=============" + user);

                int row = userService.insert(user);
                logger.info("插入成功===============" + row);
                return "one/loginPage";
            } else {
                return "redirect:/register";
            }
        }
    }


    @RequestMapping(value = "/loginOK", method = RequestMethod.GET)
    public String loginOK() {
        return "one/loginPage";
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(User user, HttpServletResponse response,Model model) throws UnsupportedEncodingException {
        logger.info("user============" + user);
        //如果能查出来数据,说明数据库里有这条数据,那么登录成功,跳转首页,否则登录失败,跳回登录页面
        //给密码加密加盐
        user.setPassword(MD5Util.MD5(user.getPassword()) + user.getId());
        logger.info("usqweqwewqewqewq===========================" + user);
        //加盐之后对比一下传进来的和数据库里的是否一致
        User dbUser = userService.selectByCondition(user.getName(), user.getPassword());
        System.out.println("dbUser=======================" + dbUser);

        DESUtil desUtil = new DESUtil();

        //DES加密
        String str1 = desUtil.encryptFromLong(System.currentTimeMillis());
        //取出数据库里的用户id
        String str2 = desUtil.encryptFromLong(dbUser.getId());
        //token由用户名,id,登录时间组成
        String token = desUtil.encrypt(str1 + "|" + user.getName() + "|" + str2);
        logger.info("token=============" + token);


        //如果没有cookie的话,就把token直接放到token里
        model.addAttribute("token",token);



        if (dbUser != null) {
            //创建cookie对象,把token放进去
            Cookie tokenCookie = new Cookie("token", token);
            System.out.println("tokenName啊===============" + tokenCookie.getName());
            System.out.println("tokenValue啊==============" + tokenCookie.getValue());
            //设置token的生命周期为30分钟
            tokenCookie.setMaxAge(30 * 60);

            //保存到客户端
            response.addCookie(tokenCookie);

            System.out.println("看看保存了没有========================");
            return "home";
        } else {
            return "one/loginPage";
        }
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
