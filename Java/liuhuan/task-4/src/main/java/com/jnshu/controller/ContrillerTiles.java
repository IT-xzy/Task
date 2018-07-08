package com.jnshu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @program: SSM_Tiles
 * @description: Tiles测试
 * @author: Mr.xweiba
 * @create: 2018-05-18 15:50
 **/

@Controller
public class ContrillerTiles {
    @RequestMapping(value = "/tilesTest1", method = RequestMethod.GET)
    public String test1(){
        return "tilesTest1";
    }

    @RequestMapping(value = "/tilesTest2", method = RequestMethod.GET)
    public String test2(){
        return "tilesTest2";
    }

    @RequestMapping(value = "/tilesTest3", method = RequestMethod.GET)
    public String test3(Model model){
        model.addAttribute("title", "body2页面");
        model.addAttribute("body", "body2");
        return "tilesTest3";
    }
}
