package com.oto.controller;

import com.oto.dao.userDao;
import com.oto.pojo.user;
import com.oto.service.userService;
import com.oto.util.DesUtil;
import com.oto.util.MD5Util;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.Charset;

/**
 * @author: 刘军鹏
 * @program: task4
 * @description:
 * @create: 2018/6/13 下午1:47
 */
@Controller
@RequestMapping("")
public class loginController {
    
    @Autowired
    userService userService;
    @Autowired
    private userDao Mapper;
    
    private static final Logger logger = Logger.getLogger(loginController.class);
    private static final String SKEY = "12345678";
    private static final Charset CHARSET = Charset.forName("gb2312");
    
    
    //    跳转注册页面
    @RequestMapping("/toregist")
    public String T() {
        
        return "regist";
        
    }
    
    
    //    注册
    @RequestMapping("/regist")
    public String regist(user user, Model model) {
        MD5Util md5 = new MD5Util();
//        得到页面传来的数据
        String name = user.getUsername();
        String pwd = user.getPassword();
//        根据页面穿过来的数据查找数据库里是否存在
        user userdb = Mapper.selectByName(name);
        if (userdb != null) {
            return "regist";
        }
        if (!("".equals(pwd))) {
//            判断输入的密码为不为空
//                加盐
            int salt = (int) ((Math.random() * 9 + 1) * 100000);
            pwd = md5.MD5(pwd + salt);
//              把加密之后的密码传入到数据库
            user.setPassword(pwd);
            user.setSalt(salt);
            userService.regist(user);
            return "logi";
        }
        return "Error";
    }
    
    //跳转登录页面
    @RequestMapping("/tologin")
    public String to() {
        return "logi";
    }
    
    
    //    登录
    @RequestMapping("/login")
    public String login(user u, HttpServletResponse response) {
//        得到页面传来的数据
        String name = u.getUsername();
        String psw = u.getPassword();
        user userdb = Mapper.selectByName(name);
        //加密
        String nameDes = name + "|" + System.currentTimeMillis();
        String nameDesResult = DesUtil.encrypt(nameDes, CHARSET, SKEY);
        
        if (userdb != null) {
//        跟数据库里的数据比对,看是否一样,可以进行登录
            if (MD5Util.MD5(psw + userdb.getSalt()).equals(userdb.getPassword())) {
//               创建一个cookie
                Cookie nameCookie = new Cookie("name", nameDesResult);
//                设置cookie的有效时间
                nameCookie.setMaxAge(60 * 60 * 24);
                response.addCookie(nameCookie);
                return "success";
            }
            
        }
        
        return "error";
        
    }
    
//    注销
    @RequestMapping("/cancel")
    public String cancel(HttpServletResponse response){
        Cookie cookie =new Cookie("name",null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "logi";
    }
    
}
