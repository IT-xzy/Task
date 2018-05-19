package com.fml.controller;

import com.fml.pojo.Vocation;
import com.fml.service.StudentService;
import com.fml.service.VocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class VocationController {
    @Autowired
    VocationService vocationService;
    @Autowired
    StudentService studentService;

    @RequestMapping("u/vocation")
    public String vocationView(Model model){
        /*各个课程的学习人数*/
        List<Integer> lessonList = studentService.getStudentByLesson();
        model.addAttribute("integerList",lessonList);

        /*职业的相关信息，工作年限和薪水没做，按写死的来*/
        List<Vocation> list = vocationService.getAllVocation();
        model.addAttribute("list",list);

        return "vocation";
    }
}
