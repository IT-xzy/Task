package com.ptteng.controller;

import com.ptteng.model.Student;
import com.ptteng.service.StudentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;
    @RequestMapping(value = "/student",method = RequestMethod.GET)
    public String findAll(Model model){
        try{
            List<Student> students = studentService.findAll();
            model.addAttribute("code", 200);
            model.addAttribute("students", students);
            return "json";
        }catch (Exception e){
            model.addAttribute("code",201);
            return "json";
        }
    }

    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public String insertStudent(Model model, Student student) {
        studentService.add(student);
        model.addAttribute("code", 200);
        model.addAttribute("message", "成功");
        return "json";
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
    public String deleteStudent(Model model, @PathVariable int id) {
        studentService.delete(id);
        model.addAttribute("code", 200);
        model.addAttribute("message", "成功");
        return "json";

    }

    @RequestMapping(value = "/student", method = RequestMethod.PUT)
    public String updateStudent(Model model, Student student) {
        studentService.update(student);
        model.addAttribute("code", 200);
        model.addAttribute("message", "成功");
        return "json";
    }


}

