package com.ptteng.controller;

import com.ptteng.model.Login;
import com.ptteng.model.User;
import com.ptteng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UserService userService;
    //
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String showLoginPage() throws  Exception{
        return "login";
    }
    @RequestMapping(value = "/loginProcess",method = RequestMethod.POST)
    public String loginProcess(Login login) throws Exception{
        String result=null;
        System.out.println(login.toString());
        if (login != null) {
            if (userService.validateUser(login)) {
                System.out.println(userService.validateUser(login));
                result= "loginSuccess";
                //用户名或密码错误，返回else中的页面
            } else {
                result= "loginError";
            }
        }
        return  result;
    }
}
