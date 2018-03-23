package com.ptteng.controller;

import com.ptteng.service.GraduateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(value = "/a/task4")
public class GraduateController {
    @Autowired
    private GraduateService graduateService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String homePage(Model model) throws Exception {
        model.addAttribute("list",graduateService.getGraduatesByCache(4));
        model.addAttribute("countStudent",graduateService.countStudentsByCache());
        model.addAttribute("countGraduate",graduateService.countGraduatesByCache());
        return "home.page";
    }

    @RequestMapping(value = "/two", method = RequestMethod.GET)
    public String secondPage() throws Exception {
        return "two.page";
    }

    @RequestMapping(value = "/three", method = RequestMethod.GET)
    public String thirdPage(Model model) throws Exception {
        return "three.page";
    }
}
