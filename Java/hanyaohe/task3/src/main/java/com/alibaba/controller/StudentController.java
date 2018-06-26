package com.alibaba.controller;

import com.alibaba.model.Student;
import com.alibaba.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.List;

//@RequestMapping(value = "student")
@Controller
public class StudentController {
    private static final Logger log = LoggerFactory.getLogger(StudentController.class);
    @Autowired
    private StudentService studentService;
    @RequestMapping(value = "/student/students", method = RequestMethod.GET)
    public String toAdd() {
        return "add";
    }
    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public String add(Student student) {
        studentService.insert(student);
        return "redirect:/student/list";
    }
    @RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
    public String delStudent(@PathVariable("id") Long id) {
        log.info("/student POST id is {}");
        studentService.deleteByPrimaryKey(id);
        return "redirect:/student/list";
    }
    @RequestMapping(value = "student/list", method = RequestMethod.GET)
    public String getStudent(Model model) {
        List<Student> studentList = studentService.list();
        model.addAttribute("studentList", studentList);
        return "list";
    }
    @RequestMapping(value = "/student/u/{id}", method = RequestMethod.GET)
    public String toUpdate(@PathVariable("id") Long id, Model model) {
        Student student = studentService.selectById(id);
        model.addAttribute("student", student);
        return "update";
    }
    @RequestMapping(value = "/student/json" ,method = RequestMethod.GET)
    public String json(Model model){
      List<Student> students =  studentService.list();
        model.addAttribute("students" ,students);
        return "jsonList";
    }
    @RequestMapping(value = "/student/{id}",method = RequestMethod.PUT)
    public String update(@PathVariable("id") Long id,String name,String qq,String major,Model model){
        Student student = new Student();
        student.setId(id);
        student.setQq(qq);
        student.setName(name);
        student.setMajor(major);
        studentService.updateByPrimaryKey(student);
        model.addAttribute("student",student);
        return "redirect:/student/list";
    }
}

