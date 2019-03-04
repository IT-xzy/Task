package com.jnshu.rmi.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jnshu.rmi.beans.Response;
import com.jnshu.rmi.beans.Student;
import com.jnshu.rmi.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@Configuration
@Controller
@EnableWebMvc
@Slf4j
@JsonIgnoreProperties
public class StudentController {




    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/students",method = RequestMethod.GET)
    @ResponseBody
    public Response findAllStudent(){
        //查询所有学生信息
        log.info("查询所有学生信息...");
        List<Student> students = studentService.findAllStu();
        log.info(students + "");
        Integer studentSize = students.size();

        log.info("学生信息条数.." + studentSize);
        if (studentSize == 0 || studentSize.equals(null)){
            log.info("学生信息查询有误." );
            return new Response(-1,"查询失败",null);
        }
        return new Response(0,"success",students);
    }


    @RequestMapping(value = "/student/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Response findStuById(@PathVariable("id") Long id){

        log.info("根据id查询学生 ..." );
        Student student = studentService.findStuById(id);
        log.info(student + "");

        if (student.equals(null)){
            return new Response(-1,"失败",null);
        }
        return new Response(0, "success",student);


    }







}
