package com.ptteng.controller;

import com.ptteng.service.GraduateService;
import com.ptteng.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

// 告诉spring mvc这是一个控制器类
@Controller    //加了这个就不需要显式实现接口了
//@ControllerAdvice  异常处理,标签的方式对代码的侵入性太强，不推荐使用
@RequestMapping(value = "/task4")
public class GraduateController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private GraduateService graduateService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String homePage(Model model) throws Exception {
        model.addAttribute("list",graduateService.selectManyGraduates(4));
        model.addAttribute("countStudent",studentService.countStudent());
        model.addAttribute("countGraduate",graduateService.countGraduate());
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
