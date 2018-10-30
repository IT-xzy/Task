package com.jnshutask.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
