package com.how2java.controller;

import com.how2java.pojo.Student;
import com.how2java.service.StudentService;
import com.how2java.util.StudentPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

@Controller
@RequestMapping("")
public class StaticController {

    @Autowired
    StudentService studentService;

    Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    //@GetMapping("/student/uuu")
    @GetMapping("/home")
    public String home(){
        System.out.println("home");
        return "home";
    }

    @GetMapping("/job")
    public ModelAndView job(StudentPage studentpage){
        System.out.println("job");
//        return "job";

        ModelAndView mav = new ModelAndView();
        List<Student> students = studentService.list(studentpage);

        int total = studentService.total();


        studentpage.caculateLast(total);


        mav.addObject("students",students);

        mav.addObject("studentpage",studentpage);

        mav.setViewName("job");

        return mav;
    }

    @GetMapping("/offer")
    public String offer(){
        System.out.println("offer");
        return "offer";
    }
}

