package com.jnshu.controller;

import com.jnshu.entity.Profession;
import com.jnshu.entity.StuStatistics;
import com.jnshu.entity.Student;
import com.jnshu.service.StuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class HomeController {


    @Resource
    StuService service;


    @GetMapping("/home")
    public String index(Model model){
        StuStatistics stuStatistics = new StuStatistics();
        List<Student> students = service.findAll();
        Integer stuCount =service.stuCount();
        Integer workCount = service.workCount();
        stuStatistics.setStuCount(stuCount);
        stuStatistics.setWorkCount(workCount);
        model.addAttribute("stu",students);
        model.addAttribute("stuStatistics",stuStatistics);
        return "home";
    }

    @GetMapping("/u/profession")
    public String profession(Model model){
        List<Profession> professions = service.findAlls();
        model.addAttribute("profession",professions);
        return "profession";
    }

}
