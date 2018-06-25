package com.task.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("")
public class JnshuController {

    @RequestMapping(value="/jnshu/welcome",method = RequestMethod.GET)
    public String getWelcome(){
        return "welcome";
    }

    @RequestMapping(value="/jnshu/manage",method = RequestMethod.GET)
    public String getManage(){

        //重定向到列表方法中
        return "redirect:/u/students";
    }
}