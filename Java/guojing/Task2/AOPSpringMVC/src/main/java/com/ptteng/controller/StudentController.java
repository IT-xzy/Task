package com.ptteng.controller;


import com.ptteng.Student;
import com.ptteng.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public String list(Model model) {
        List<Student> students = studentService.findAll();
        model.addAttribute("students", students);
        return "list";

    }

    @RequestMapping(value = "/student/down/{id}", method = RequestMethod.GET)
    public String beforeDelete(@PathVariable("id") long id, Model model) {
        System.out.println("第一次id=====" + id);
        Student student = studentService.fingById(id);
        model.addAttribute("student", student);
        return "delete";
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") long id, Model model) {
        System.out.println("第2次id=====" + id);
        studentService.deleteStudent(id);
        List<Student> students = studentService.findAll();
        model.addAttribute("students", students);
        return "list";
    }


    @RequestMapping(value = "/student/up/{id}", method = RequestMethod.GET)
    public String beforeUpdate(@PathVariable("id") long id, Model model) {
        System.out.println("修改位置" + id);
        Student student = studentService.fingById(id);
        model.addAttribute("student", student);
        return "update";
    }

    @RequestMapping(value = "/student", method = RequestMethod.PUT)
    public String update(Student student, Model model) {
        System.out.println("修改哒" + student);
        studentService.updateStudent(student);
        List<Student> students = studentService.findAll();
        model.addAttribute("students", students);
        return "list";
    }


    @RequestMapping(value = "/student/add", method = RequestMethod.GET)
    public String beforeInsert(Student student, Model model) {
        model.addAttribute("student", student);
        return "insert";
    }

    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public String insert(Student student, Model model) {
        System.out.println(student);
        student.setUpdateAt(System.currentTimeMillis());
        student.setCreateAt(System.currentTimeMillis());
        studentService.insertStudent(student);
        List<Student> students = studentService.findAll();
        model.addAttribute("students", students);
        return "list";
    }


}
