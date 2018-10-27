package com.controller;

import com.entity.Student;
import com.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/student",method = RequestMethod.GET)
    public ModelAndView findStudent(){
        System.out.println("哈哈哈，我来首页了！");
        ModelAndView modelAndView=new ModelAndView();

//        获取所有的优秀学员信息（根据salary排名取前四位）
        List<Student> studentList=studentService.findStudent();
        System.out.println(studentList);

        Long totalStudent=studentService.countStudent(null);
        System.out.println(totalStudent);

        modelAndView.addObject("data",studentList);
        modelAndView.addObject("item","body1");
        modelAndView.setViewName("myView");
        modelAndView.addObject("totalStudent",totalStudent);
        return modelAndView;
    }

}
