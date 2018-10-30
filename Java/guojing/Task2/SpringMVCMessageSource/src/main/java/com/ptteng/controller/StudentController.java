package com.ptteng.controller;


import com.ptteng.Student;
import com.ptteng.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public ModelAndView allStudent(ModelAndView modelAndView) {
        List<Student> students = studentService.findAll();
        if (students != null) {
            modelAndView.addObject("code", 0);
            modelAndView.addObject("data", students);
        } else {
            modelAndView.addObject("code", 1);
        }
        modelAndView.setViewName("json");
        return modelAndView;
    }


    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public ModelAndView addStudent(ModelAndView modelAndView, Student student) {
        student.setCreateAt(System.currentTimeMillis());
        student.setUpdateAt(System.currentTimeMillis());
        try {
            studentService.insertStudent(student);
            modelAndView.addObject("code", 101);
        } catch (Exception e) {
            e.printStackTrace();
//      姓名设置的是非空，当插入的数据没有姓名时，程序会崩溃。这里是为了防止崩溃，给出102.
            modelAndView.addObject("code", 102);
        }
        modelAndView.setViewName("json");
        return modelAndView;
    }


    @RequestMapping(value = "student", method = RequestMethod.PUT)
    public ModelAndView updateStudent(ModelAndView modelAndView, Student student) {
        student.setUpdateAt(System.currentTimeMillis());
        try {
//            更新失败（输入的id没有）给出104，成功给出103
            boolean row = studentService.updateStudent(student);
            System.out.println(row);
            if (row == true) {
                modelAndView.addObject("code", 103);
            } else {
                modelAndView.addObject("code", 104);
            }
        } catch (Exception e) {
//          printStackTrace()方法的意思是：在命令行打印异常信息
//          在程序中出错的位置及原因。（这是白话解释，比较容易理解）
            e.printStackTrace();
            modelAndView.addObject("code", 104);
        }

        modelAndView.setViewName("json");
        return modelAndView;
    }


    @RequestMapping(value = "student/{id}", method = RequestMethod.DELETE)
    public ModelAndView deleteStudent(@PathVariable("id") long id, ModelAndView modelAndView) {
        boolean row = studentService.deleteStudent(id);
        System.out.println(row);
        if (row == true) {
            modelAndView.addObject("code", 105);
        } else {
            modelAndView.addObject("code", 106);
        }
        modelAndView.setViewName("json");
        return modelAndView;
    }


}
