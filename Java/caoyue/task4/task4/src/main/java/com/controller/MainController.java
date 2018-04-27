package com.controller;

import com.POJO.Cooperation;
import com.POJO.GreatStudent;
import com.POJO.HowToStudy;
import com.service.GreatStudentService;
import com.service.GreatStudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: 曹樾
 * @program: task4
 * @description: 主页面
 * @create: 2018/4/23 下午4:13
 */

@Controller
public class MainController {
    @Autowired
    GreatStudentServiceImpl greatStudentServiceImpl;
    @RequestMapping("/index")
    public String select(Model model) throws Exception {
        List<GreatStudent> greatStudents = greatStudentServiceImpl.findUserByName();
        List<Cooperation> cooperation = greatStudentServiceImpl.findCooperation();
        List<HowToStudy> howToStudies = greatStudentServiceImpl.findStudy();
        
        model.addAttribute("lists",greatStudents);
        model.addAttribute("cooperation",cooperation);
        model.addAttribute("study",howToStudies);
        
        return "first";
    }
}
