package com.task.controller;


import com.task.entity.Student;
import com.task.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("")
public class StudentController {

    //加载service

    @Autowired
    StudentService studentService;


    @RequestMapping(value = "/student",method = RequestMethod.GET)
    public ModelAndView listStudentById(String id,String name,String number){

        //获取搜索选项 id>>name>>number

        System.out.println("id:"+id);
        System.out.println("name:"+name);
        System.out.println("number:"+number);

        //获取搜索结果 全部以list存储,初始化为null
        List<Student> students = null;


        if(!id.equals("")){
            students = studentService.findById(Integer.parseInt(id));
        }else if(!name.equals("")){
            students = studentService.findByName(name);
        }else if(!number.equals("")){
            students = studentService.findByNumber(Integer.parseInt(number));
        }

        ModelAndView mav = new ModelAndView();
        mav.addObject("students",students);
        mav.setViewName("manage");

        return mav;

    }

}
