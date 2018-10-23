package com.jnshuboot.controller;

import com.jnshuboot.pojo.Login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HelloController {

    @RequestMapping("/")
    public String hhController() {
        return "index";
    }

    @RequestMapping("/index")
    public String indexController() {
        return "index";
    }

    @RequestMapping("/hello")
    public String hellController() {
        return "hello";
    }

    @RequestMapping("/fail")
    public String failedController() {
        return "failed";
    }

}
