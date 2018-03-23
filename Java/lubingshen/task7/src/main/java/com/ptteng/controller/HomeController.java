package com.ptteng.controller;

import com.ptteng.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(value = "/a")
// TODO 对于一些高频率发生的业务错误，最好别用异常来处理，会导致性能下降，最好分支判断后直接返回json数据，这个项目我就偷下懒
public class HomeController {
    @Autowired
    private HomeService graduateService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String homePage(Model model) throws Exception {
        model.addAttribute("list", graduateService.getGraduatesByCache(4));
        model.addAttribute("countStudent", graduateService.countStudentsByCache());
        model.addAttribute("countGraduate", graduateService.countGraduatesByCache());
        return "home.page";
    }

    @RequestMapping(value = "/two", method = RequestMethod.GET)
    public String secondPage() throws Exception {
        return "two.page";
    }

    @RequestMapping(value = "/three", method = RequestMethod.GET)
    public String thirdPage() throws Exception {
        return "three.page";
    }

}
