package com.zyq.controller;

import com.zyq.pojo.ExcellentStudent;
import com.zyq.pojo.Profession;
import com.zyq.service.ExcellentStudentService;
import com.zyq.service.ProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("")
public class MyController {

    @Autowired
    ProfessionService professionService;
    @Autowired
    ExcellentStudentService excellentStudentService;
//    跳转首页
    @RequestMapping(value = "/index")
    public String indexView(Model model) {
        model.addAttribute("item","indexBody");
        List<ExcellentStudent> list = excellentStudentService.selectByOrder();
        model.addAttribute("list",list);
        return "myView";
    }
//    跳转关于（about）页面
    @RequestMapping(value = "/about")
    public String aboutView(Model model) {
        model.addAttribute("item","aboutBody");
        return "myView";
    }
//    跳转职业页面
    @RequestMapping(value = "/profession")
    public String professionView(Model model) {
        List<Profession> list = professionService.selectAll();
        model.addAttribute("item","professionBody");
        model.addAttribute("list",list);
        return "myView";
    }
}
