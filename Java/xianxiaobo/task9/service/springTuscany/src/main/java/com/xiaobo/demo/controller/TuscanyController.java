package com.xiaobo.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TuscanyController {
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    @ResponseBody
    public String getTest(){
        return "It's a test";
    }

}
