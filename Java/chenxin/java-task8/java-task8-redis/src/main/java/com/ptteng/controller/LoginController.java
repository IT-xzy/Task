package com.ptteng.controller;

import com.ptteng.model.Login;
import com.ptteng.model.User;
import com.ptteng.rmi.server.ServerA;
import com.ptteng.service.UserService;
import com.ptteng.util.DESAlgorithm;
import com.ptteng.util.MD5CipherTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private ServerA serverA;


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("utf-8");
        return "login";
    }

    @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
    public String loginProcess(HttpServletRequest request, HttpServletResponse response, Login login) throws Exception {
        UserService userService = serverA.getUserService();
        String result = null;
        System.out.println(login.toString());
        String message= "";
        if (login.getUsername() != "" && login.getPassword() != "") {
            String key = "chenxin@#*";
            DESAlgorithm des = new DESAlgorithm();
            //密码加密
            String passward = des.encrypt(login.getPassword(), key);
            //密码加盐
            MD5CipherTest MD5= new MD5CipherTest();
            String salt = "j@)o8&*0@";
            passward = MD5.cipherMethod(passward+salt);

            login.setPassword(passward);
            long id = userService.validateUser(login);
            System.out.println(id);
            if (id >= 1) {
                System.out.println(userService.validateUser(login));
                String cookieValue;
                User user = userService.getUserById(id);
                cookieValue = des.encrypt(String.valueOf(user.getId())+"."+String.valueOf(user.getCreatedAt()), key);

                Cookie cookie = new Cookie("test", cookieValue );
                //+ "*" + des.decrypt(cookieValue, key)
                response.setCharacterEncoding("utf-8");
                cookie.setMaxAge(60 * 3*100);
                cookie.setPath("/");
                cookie.setDomain("localhost");
                response.addCookie(cookie);
                message ="欢迎，"+user.getUsername();
//                cookie.setValue(user.getUsername() + user.getId());
                request.setAttribute("message", message);
                result = "forward:/home1";
                //用户名或密码错误，返回else中的页面
            } else {
                message="用户名或密码不正确！";
                request.setAttribute("message", message);
                result = "login";
            }
        } else {
            message="用户名或密码不能为空！";
            request.setAttribute("message", message);
            result = "login";
        }
        return result;
    }

}
