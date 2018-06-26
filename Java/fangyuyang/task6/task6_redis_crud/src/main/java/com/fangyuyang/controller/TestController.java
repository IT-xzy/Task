package com.fangyuyang.controller;

import com.fangyuyang.model.Student;
import com.fangyuyang.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.LinkedList;
import java.util.List;

@Controller
public class TestController {

    @Autowired
    private StudentService studentService;
    @RequestMapping("/")
    public String main(){ return  "main";}
    @RequestMapping("/students")
    public String user(Student student, Model model) {
       Logger logger = LoggerFactory.getLogger(TestController.class);

//        PageHelper.startPage(pn,4);//一页对应四个数据
        List<Student> students =new LinkedList<>();
        logger.info("测试,{}");
        students.add((Student) studentService.redisGet("1"));
        logger.info("测试,{}");
        students.add((Student) studentService.redisGet("2"));
        students.add((Student) studentService.redisGet("3"));
        students.add((Student) studentService.redisGet("4"));
        students.add((Student) studentService.redisGet("5"));
        students.add((Student) studentService.redisGet("6"));
        students.add((Student) studentService.redisGet("7"));
         students = studentService.findAll();
//        PageInfo page = new PageInfo(list,4);//将所有数据分的页数
        model.addAttribute("student" ,students);//传入
        logger.info("学生： {}",students);
        return "json";
    }
    @RequestMapping(value = "/student",method = RequestMethod.GET)
    public String postStudent(Model model,Student student){
       Logger logger = LoggerFactory.getLogger(TestController.class);
        logger.info("处理的学生：{} ",student.getName());
        return "Post";

    }
    @RequestMapping(value = "/student",method=RequestMethod.POST)
    public String addStudent(Student student){
            studentService.addStudent(student);
        Logger logger = LoggerFactory.getLogger(TestController.class);
        logger.info("增加的学生： {}",student.getName());
        return "redirect:/students";
    }

    @RequestMapping(value="/student/{id}", method=RequestMethod.DELETE)
    public String deleteUser(@PathVariable("id") int id) {
        studentService.deleteStudent(id);
        Logger logger = LoggerFactory.getLogger(TestController.class);
        logger.info("删除的学生： {}", studentService.findStudentById(id));
        return "redirect:/students";
    }

    @RequestMapping(value = "/student",method =RequestMethod.PUT)
    public String updateStudent(Student student)
    {
        studentService.updateStudent(student);
       Logger logger = LoggerFactory.getLogger(TestController.class);
        logger.info("更改的学生：{} ",student.getName());
            return "redirect:/students";
    }
    @RequestMapping(value="/student/{id}", method=RequestMethod.GET)
    public String getStudent(@PathVariable("id") int id, Model model)
    {
        model.addAttribute("student", studentService.findStudentById(id));
        Logger logger = LoggerFactory.getLogger(TestController.class);
        logger.info("准备更改的学生： {}", studentService.findStudentById(id));
        return "Put";
    }
}

