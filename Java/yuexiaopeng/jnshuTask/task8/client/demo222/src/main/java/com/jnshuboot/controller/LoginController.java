package com.jnshuboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @RequestMapping("/")
    public String indexController() {
        return "index";
    }

    @RequestMapping("/login")
    public String loginController() {
        return "login";
    }

    @RequestMapping("/index")
    public String index2Controller() {
        return "index";
    }

    @RequestMapping("/user/detail")
    public String userDetailController() {
        return "detail";
    }

    @RequestMapping("/admin/detail")
    public String adminDetailController() {
        return "admin/detail";
    }
//    @RequestMapping("/loginError")
//    public String errorController(){
//        return "error";
//    }
}
