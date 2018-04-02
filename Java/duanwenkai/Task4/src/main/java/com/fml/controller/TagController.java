package com.fml.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TagController {

    @RequestMapping(value = "testTag",method = RequestMethod.POST)
    public String tagTest(Long value, String pattern, Model model){
        model.addAttribute("value",value);
        model.addAttribute("pattern",pattern);
        return "tagTest";
    }

    @RequestMapping("tagView")
    public String tagView(){
        return "viewTest";
    }
}
