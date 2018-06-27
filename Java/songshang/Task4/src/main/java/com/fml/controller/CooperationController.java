package com.fml.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CooperationController {


    @RequestMapping(value = "cooperation",method = RequestMethod.GET)
    public String cooperationView(){
        return "cooperation";
    }
}
