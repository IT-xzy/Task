package com.jnshu.controller;

import com.jnshu.model.Student;
import com.jnshu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StudentTestController {
    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/select", method = RequestMethod.GET)
    public String selectAll(Model model) {

        List<Student> students = studentService.findAll();
        model.addAttribute("code", 200);
        model.addAttribute("message", "成功");
        model.addAttribute("students", students);
        return "json";
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
