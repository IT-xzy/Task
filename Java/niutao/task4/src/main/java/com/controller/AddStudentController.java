package com.controller;

import com.mapper.StudentMapper;
import com.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AddStudentController {
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    Student student;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String hello(Model model) {
        Student student = new Student();
        student = studentMapper.selectByPrimaryKey(1);
        model.addAttribute("student",student);
        return "hello";
    }

    @RequestMapping(value = "/home10",method = RequestMethod.GET)
    public String show10() {
        return "home10";
    }

    @RequestMapping(value = "/home11",method = RequestMethod.GET)
    public String show11() {
        return "home11";
    }
}




