package com.myitschool.controller;

import com.myitschool.service.baseService;
import com.myitschool.student.Student;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

//@RestController
@Controller
@RequestMapping("/itschool")
public class restController {

    public restController(){}

    @Autowired
    private baseService studentService;

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public ModelAndView listAllStudents() {
        List<Student> students = studentService.allStudent();
        ModelAndView modelAndView = new ModelAndView("students");
        modelAndView.addObject("students", students);
        return modelAndView;
    }

    @RequestMapping(value = "/students/student", method = RequestMethod.GET)
    public ModelAndView getStudent(@RequestParam("id") int id) {
        Student student = studentService.selectStudent(id);
        List<Student> students = new ArrayList<Student>();
        if (null != student) {
            students.add(student);
        }
        ModelAndView modelAndView = new ModelAndView("students");
        modelAndView.addObject("students", students);
        return modelAndView;
    }

    @RequestMapping(value = "/students", method = RequestMethod.POST)
    public ModelAndView createStudent(@ModelAttribute("student") Student student) {
        int flag = 1;
        studentService.insertStudent(student);
        List<Student> students = studentService.allStudent();
        ModelAndView modelAndView = new ModelAndView("students");
        modelAndView.addObject("students", students);
        modelAndView.addObject("flag", flag);
        return modelAndView;
    }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public ModelAndView deleteStudent(@PathVariable("id") int id) {
        int flag = studentService.deleteStudent(id);
        List<Student> students = studentService.allStudent();
        ModelAndView modelAndView = new ModelAndView("students");
        modelAndView.addObject("students", students);
        modelAndView.addObject("flag", flag);
        return modelAndView;
    }

    @RequestMapping(value = "/students/profile/{id}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public ModelAndView updateStudentInformation(@PathVariable("id") int id) {
        Student student = studentService.selectStudent(id);
        ModelAndView modelAndView = new ModelAndView("profile");
        modelAndView.addObject("student", student);
        return modelAndView;
    }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.POST)
    public ModelAndView updateStudent(@PathVariable("id") int id, @ModelAttribute("student") Student student) {
        student.setId(id);
        int flag = studentService.updateStudent(student);
        List<Student> students = new ArrayList<Student>();
        students.add(studentService.selectStudent(id));
        ModelAndView modelAndView = new ModelAndView("students");
        modelAndView.addObject("students", students);
        modelAndView.addObject("flag", flag);
        return modelAndView;
    }

    //学生详细信息
    @RequestMapping(value = "/students/profile")
    public String information() {
        return "profile";
    }

    //目录
    @RequestMapping(value = "/menu")
    public String menu() {
        //返回一个menu.jsp这个视图
        return "menu";
    }
}
