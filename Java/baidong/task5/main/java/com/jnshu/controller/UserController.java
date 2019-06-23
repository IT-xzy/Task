package com.jnshu.controller;


import com.jnshu.DESUtil;
import com.jnshu.Jwt;
import com.jnshu.MD5Util;
import com.jnshu.model.User;
import com.jnshu.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.List;


@Controller
public class UserController {
    private static final Logger logger = Logger.getLogger(UserController.class);
    @Autowired
    public UserService userService;

    //输入一个网址来访问web-Inf的jsp界面
    @RequestMapping(value = "/a/register", method = RequestMethod.GET)
    public String register() {
        return "register";
    }


    //    注册
//进行判断，输入的信息有User集合的全部信息，和单独用来判断的那么信息，一开始想的是先将User集合中的name用get方法取出来，进行判断，现在是只需要直接将User，name传输进来
    @RequestMapping(value = "/a/register", method = RequestMethod.POST)
    public String insert(User user, String name) {

        if (!ObjectUtils.isEmpty(user.getName()) && !ObjectUtils.isEmpty(user.getPassword())) {
            logger.info("输入的账户信息===============" + user);
//        用name来查询数据库中是否有该用户存在的信息，
            List<User> users = userService.selectByName(name);
            logger.info("通过name查找的user表中的信息" + users);
//        进行判断user表中有没有这个用户，有的话直接跳转注册界面，没有的话进行注册
            if (!CollectionUtils.isEmpty(users)) {
                logger.info("该用户已存在===========");
                return "redirect:/a/register";
            } else {
//            如果用户不存在，先判断用户和密码是否符合要求的格式，符合的话，就进行注册,然后跳转到登录界面，
                if (
                        user.getName() != null && user.getName().length() > 0
                                && user.getPassword() != null && user.getPassword().length() > 0
                ) {
                    logger.info("注册账户信息=============" + user);
                    //                MD5给密码加密加盐
                    user.setPassword(MD5Util.MD5(user.getPassword()) + user.getId());
                    int a = userService.insert(user);

                    logger.info("注册成功=========" + a);

                    return "login";
                } else {
                    return "redirect:/a/register";
                }
            }
        } else {
            logger.info("用户名密码为空================");
            return "login";
        }
    }


////    登录页面
//
//    //输入一个网址来访问登录页面
//    @RequestMapping(value = "/a/login", method = RequestMethod.GET)
//    public String login() {
//        return "login";
//    }


    @RequestMapping(value = "/a/login", method = RequestMethod.GET)

    public String login(User user, HttpServletResponse response) throws UnsupportedEncodingException {

        if (!ObjectUtils.isEmpty(user.getName()) && !ObjectUtils.isEmpty(user.getPassword())) {
            logger.info("登录信息========" + user.getName() + user.getPassword());
//        这个方法执行,没有返回值
            user.setPassword(MD5Util.MD5(user.getPassword()) + user.getId());
            logger.info("给登录密码加密加盐==========" + user);
            List<User> list = userService.selectByCondition(user.getName(), user.getPassword());
            logger.info("数据库中的这条数据为" + list);
//        先进行确保输入的密码正确
            if (!CollectionUtils.isEmpty(list)) {


//            采用DES给token加密==================================================================
//DES加密
//先将时间和id进行加密，第一次加密
                String str1 = DESUtil.encryptFromLong(System.currentTimeMillis());
                String str2 = DESUtil.encryptFromLong(user.getId());
//token 由用户名，id，登录时间组成，第二次加密
                String token = DESUtil.encrypt(str1 + "|" + user.getName() + "|" + str2);
                logger.info("token ==========" + token);
                Cookie tokenCookie = new Cookie("token", token);
//          设置token的生命周期为30分钟
                tokenCookie.setMaxAge(30 * 60);
//            将cookie放到响应头中，返回给客户端
                response.addCookie(tokenCookie);
//            保存cookie到客户端
//===================================================================================

//    设置cookie=============================================
////            在第一次登录的时候就创建一个cookie
//            Cookie nameCookie = new Cookie("name", user.getName());
                ////            设置生命周期30分钟
//            nameCookie.setMaxAge(30 * 60);
                //            response.addCookie(nameCookie);
//               创建cookie对象,把token放进去
//===============================================================

//使用jwt========================================================
//            Cookie jetCookie = new Cookie("token", Jwt.createJWT(user.getName()));
//            //            设置生命周期30分钟
//            jetCookie.setMaxAge(30 * 60);
//            response.addCookie(jetCookie);
                return "home";
            } else {
                return "login";
            }
        } else {
            logger.info("用户名密码为空================");
            return "login";
        }
    }

    //    注销
    @RequestMapping(value = "/a/u/logout", method = RequestMethod.GET)
    public String logout(HttpServletResponse response, HttpServletRequest Request) {
        //创建一个cookie对象,得到cookie
        Cookie[] cookies = Request.getCookies();
        //先取出cookie
        for (Cookie cookie : cookies) {
//如果存在name为token的cookie,则取出并修改token的时效为0
            if (cookie.getName().equals("token")) {
                cookie.setValue(null);
                cookie.setMaxAge(0);
                logger.info("被删除的token是" + cookie.getName());
                response.addCookie(cookie);
                return "home";
            } else {
                logger.info("修改失败");

            }

        }
        return "home";
    }
}
