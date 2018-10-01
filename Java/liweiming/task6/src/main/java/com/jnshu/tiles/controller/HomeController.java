package com.jnshu.tiles.controller;

import com.jnshu.tiles.entity.Profession;
import com.jnshu.tiles.entity.StuStatistics;
import com.jnshu.tiles.entity.Student;
import com.jnshu.tiles.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    ServiceImpl service;


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
