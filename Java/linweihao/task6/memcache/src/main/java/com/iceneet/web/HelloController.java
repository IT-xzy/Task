package com.iceneet.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/hello")
public class HelloController {
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String printHello() {
        return "hello";
    }

}
