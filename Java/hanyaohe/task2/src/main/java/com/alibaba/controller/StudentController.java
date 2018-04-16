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
//    @Resource
//    private StudentService studentService;
//
//    @RequestMapping(value = "/student/students", method = RequestMethod.GET)
//    public String toAdd() {
//        return "add";
//    }
//
//    @RequestMapping(value = "/student", method = RequestMethod.POST)
//    public String add(Student student) {
//        studentService.insert(student);
//        return "redirect:/student/list";
//    }
//
//    @RequestMapping(value = "/student/list", method = RequestMethod.GET)
//    public String allGet(Model model) {
//        List<Student> student = studentService.list();
//        model.addAttribute("student", student);
//        return "list";
//    }
//
//    @RequestMapping(value = "first", method = RequestMethod.GET)
//    public String frist1() {
//        return "first";
//    }
//
//    @RequestMapping(value = "test/second", method = RequestMethod.GET)
//    public String second1(Long id, Model model) {
//        Student student = studentService.selectById(id);
//        model.addAttribute("student", student);
//        return "second";
//    }
//
//    @RequestMapping(value = "/student/json", method = RequestMethod.GET)
//    public String json(Model model) {
//        List<Student> studentList = studentService.list();
//        model.addAttribute("students", studentList);
//        return "jsonList";
//    }
//
//    @RequestMapping(value = "student/{id}", method = RequestMethod.DELETE)
//    public String delStudent(@PathVariable("id") Long id) {
//        studentService.deleteByPrimaryKey(id);
//        return "redirect:/student/list";
//    }
//
//    @RequestMapping(value = "student/u/{id}", method = RequestMethod.GET)
//    public String toUpdate(@PathVariable("id") Long id, Model model) {
//
//        Student student = studentService.selectById(id);
//        model.addAttribute("student", student);
//        return "update";
//    }
//
//    @RequestMapping(value = "student/{id}", method = RequestMethod.PUT)
//    public String update(@PathVariable("id") Long id, String name, String qq, String major, Model model) throws UnsupportedEncodingException {
//        log.info("the charset is {}", Charset.defaultCharset());
//        log.info("student/{}  PUT the params are name:{},qq:{},major:{} ", id, name, qq, major);
//        Student student = new Student();
//        student.setId(id);
//        student.setMajor(major);
//        student.setName(name);
//        student.setQq(qq);
//        boolean success = studentService.updateByPrimaryKey(student);
//        log.info("update student success :{}", success);
//        model.addAttribute("student", student);
//        return "redirect:/student/list";
//    }
//
//
//    @RequestMapping(value = "/student/fuck/{id}", method = RequestMethod.GET)
//    public String fuck(@PathVariable("id") Long id, Model model) {
//        log.info("/student/fuck  GET id is {}", id);
//        Student student = studentService.selectById(id);
//        model.addAttribute(student);
//        return "id";
//    }
//
//    @RequestMapping(value = "/student/fuck/{id}", method = RequestMethod.PUT)
//    public String fuckMore(@PathVariable("id") Long id, String name, String qq,String major,Model model) {
//        log.info("/student/fuck PUT id is {} ,name is {}", id, name);
//        Student student = new Student();
//        student.setId(id);
//        student.setName(name);
//        student.setQq(qq);
//        student.setMajor(major);
//        boolean updateSuccess = studentService.updateByPrimaryKey(student);
//        log.info("updateSuccess:{}", updateSuccess);
//        model.addAttribute(student);
//        return "redirect:/student/list";
//
//    }


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
    @RequestMapping(value = "/student/{id}",method = RequestMethod.PUT)
    public String update(@PathVariable("id") Long id, String name,String qq,String major,Model model){
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setQq(qq);
        student.setMajor(major);
        studentService.updateByPrimaryKey(student);
        model.addAttribute("student" ,student);
        return "redirect:/student/list";
    }
    @RequestMapping(value = "/student/json" ,method = RequestMethod.GET)
    public String json(Model model){
      List<Student> students =  studentService.list();
        model.addAttribute("students" ,students);
        return "jsonList";
    }
}

