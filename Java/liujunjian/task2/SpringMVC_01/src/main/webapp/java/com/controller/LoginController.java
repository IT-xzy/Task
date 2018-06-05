package com.controller;

import com.loginCheck.LoginCheck;
import com.pojo.Administrator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Administrator administrator) throws Exception{ // 从前台页面取得参数值
        if (LoginCheck.check(administrator.getUsername(), administrator.getPassword()) != "") {
            return "success";
        } else {
            return "login";
        }
    }
}
