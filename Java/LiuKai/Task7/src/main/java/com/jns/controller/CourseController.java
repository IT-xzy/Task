package com.jns.controller;

import com.jns.pojo.Course;
import com.jns.service.impl.CourseServiceImpl;
import com.jns.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("u")
public class CourseController {
    @Autowired
    CourseServiceImpl courseService;

    @Autowired
    StudentServiceImpl studentService;

    @RequestMapping(value = "/course")
    public ModelAndView cp(){
        ModelAndView modelAndView=new ModelAndView("coupage1");
        Course web =courseService.findCourse(1);
        Course java =courseService.findCourse(2);
        modelAndView.addObject("web",web);
        modelAndView.addObject("java",java);
        int webNum=0;
        int javaNum=0;
        webNum=studentService.countCourse("web");
        javaNum=studentService.countCourse("java");
        modelAndView.addObject("webNum",webNum);
        modelAndView.addObject("javaNum",javaNum);
        return modelAndView;
    }

}
