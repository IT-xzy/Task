package com.fml.controller;

import com.fml.pojo.User;
import com.fml.service.UserService;
import com.fml.annotion.ValidateFiled;
import com.fml.annotion.ValidateGroup;
import com.fml.utils.CookieUtil;
import com.fml.utils.JWTUtil;
import com.fml.utils.MD5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;


@Controller
@RequestMapping("u")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    /**
     * 注册跳转
     * @return
     */
    @RequestMapping(value = "register",method = RequestMethod.GET)
    public String register(){
        return "register";
    }

    /**
     * 注册提交
     * @param entity 注册的用户
     * @return
     */
    /*@RequestMapping(value = "subRegister",method = RequestMethod.POST)
    public String subRegister(@Valid User entity, BindingResult result){
        *//*后台获得前台的状态码，进行注册验证，注册后将状态码登信息封装，返回前台*//*

        if (result.hasErrors()){
            return "error";
        }

        //System.out.println(entity);

        String userName = entity.getUserName();
        User user = userService.getByName(userName);
        if (user != null){
            LOGGER.info("该用户已经存在！");
            return "register";
        }

        if (userService.add(entity)){
            LOGGER.info("用户注册成功！");

            *//*注册成功后直接登录（功能未实现）*//*


            return "login";
        }else {
            LOGGER.error("程序发生错误！");
            return "error";
        }
    }*/


    @ValidateGroup(fileds = {
            @ValidateFiled(index=0 , notNull=true ),
            @ValidateFiled(index=0 , notNull=true , filedName="userName" , minLen = 2 ,maxLen = 8) ,
            @ValidateFiled(index=0 , notNull=true , filedName="phone" , minLen = 11 ,maxLen = 11) ,
            @ValidateFiled(index=0 , notNull=true , filedName="email" , regStr = "^(.+)@(.+)$") ,
            @ValidateFiled(index=0 , notNull=true , filedName="password" , minLen = 6 ,maxLen = 10)
    })
    @RequestMapping(value = "subRegister",method = RequestMethod.POST)
    public String subRegister(User entity){
        /*后台获得前台的状态码，进行注册验证，注册后将状态码登信息封装，返回前台*/

        //System.out.println(entity);

        String userName = entity.getUserName();
        User user = userService.getByName(userName);
        if (user != null){
            LOGGER.info("该用户已经存在！");
            return "register";
        }

        if (userService.add(entity)){
            LOGGER.info("用户注册成功！");

            /*注册成功后直接登录（功能未实现）*/


            return "login";
        }else {
            LOGGER.error("程序发生错误！");
            return "error";
        }
    }

    /**
     * 登录跳转
     * @return
     */

    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }


    /**
     * 登录提交
     * @param entity 登录的用户
     * @param response 回写cookie
     * @return
     */
    @RequestMapping(value = "subLogin",method = RequestMethod.POST)
    public String subLogin(User entity, HttpServletRequest request, HttpServletResponse response){
        User user = userService.getByEmail(entity.getEmail());
        System.out.println(user);
        String pwd = user.getPassword();
        System.out.println(pwd);
        String salt = user.getSalt();

        //判断账户密码是否匹配
        if (!MD5Util.getMd5withSalt(entity.getPassword(),salt).equals(pwd)){
            LOGGER.info("登陆失败！");
            return "redirect:/login";
        }

        //前两个都是张三的登录（差10秒），后面是李四的登录，最后一个是5分钟后张三的登录

        //eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjAiLCJleHAiOjE1MjI1NzQwODksImlhdCI6MTUyMjU3MjI4OX0.BTUhYYC08oJUzTnuPrsAIXiGuhhdpPBxE_p2h02XR-4
        //eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjAiLCJleHAiOjE1MjI1NzQwODksImlhdCI6MTUyMjU3MjI4OX0.BTUhYYC08oJUzTnuPrsAIXiGuhhdpPBxE_p2h02XR-4
        //eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjAiLCJleHAiOjE1MjI1NzQzMTIsImlhdCI6MTUyMjU3MjUxMn0.L4UhMyWzSOWUcN1bPaEJsA_knILFejA3SKhH_S1LaHE
        //eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjAiLCJleHAiOjE1MjI1NzQzODYsImlhdCI6MTUyMjU3MjU4Nn0.gSwM3h4acsoKMWhcs8AI1vPIJtyk_PiX3MKaKgAMCAk
        //request.getSession().setAttribute("");

        try {
            String token = JWTUtil.createToken(user);

            //令牌信息存入Cookie
            response.addCookie(CookieUtil.getLoginCookie("tokens",token));
            LOGGER.info(new Date() + ": 用户登录成功！");
        } catch (Exception e) {
            LOGGER.info("生成token失败！");
            e.printStackTrace();
        }
        return "home";
    }


    /**
     * 退出
     * @return
     */
    @RequestMapping(value = "logout",method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response){
        Cookie cookie = CookieUtil.deleteCookieByName(request,"token");
        response.addCookie(cookie);
        return "login";
    }

}
