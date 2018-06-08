package com.controller;

import com.POJO.Profession;
import com.service.GreatStudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author: 曹樾
 * @program: task4
 * @description: 职业页面
 * @create: 2018/4/24 上午9:25
 */

@Controller
public class ProfessionController {
    @Autowired
    GreatStudentServiceImpl greatStudentServiceImpl;
    @RequestMapping("/profession")
    public String select(Model model) throws Exception {
        List<Profession> Front = greatStudentServiceImpl.findFront();
        List<Profession> After = greatStudentServiceImpl.findAfter();
        List<Profession> OP = greatStudentServiceImpl.findOP();
        List<Profession> PM = greatStudentServiceImpl.findPM();
        System.out.println(Front);
        model.addAttribute("afters",After);
        model.addAttribute("fronts",Front);
        model.addAttribute("ops",OP);
        model.addAttribute("pms",PM);
        return "second";
    }
}
