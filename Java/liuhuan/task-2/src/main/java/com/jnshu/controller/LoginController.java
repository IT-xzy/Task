package com.jnshu.controller;

import com.jnshu.model.Auth;
import com.jnshu.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/* 认证Controller */
@Controller
public class LoginController {
    //日志
    private static Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    UserService userService;
    //登陆 会影响api
    @RequestMapping("/login.action")
    public String login(HttpSession session, Auth auth) throws Exception {
        if(userService.findAuth(auth)){
            //在session中保存用户身份信息
            session.setAttribute("username", auth.getUsername());
        }
        //重定向到用户信息页面
        return "redirect:/userList.action";
    }

    //退出登陆
    @RequestMapping("logout")
    public String logout(HttpSession session){
        //删除session
        session.invalidate();
        return "redirect:/login.action";
    }
}
