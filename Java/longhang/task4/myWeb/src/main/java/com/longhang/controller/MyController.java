package com.longhang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class MyController {
    @RequestMapping("")
    public String get(){
        return "index";
    }
}
