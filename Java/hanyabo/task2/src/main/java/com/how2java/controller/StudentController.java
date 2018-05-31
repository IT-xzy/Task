package com.how2java.controller;


import com.how2java.pojo.Student;
import com.how2java.service.StudentService;
import com.how2java.util.StudentPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

@Controller
@RequestMapping("")
public class StudentController {

    @Autowired
    StudentService studentService;

    Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @GetMapping("/student")
    public ModelAndView listStudent(StudentPage studentpage){


        logger.info(studentpage);

        ModelAndView mav = new ModelAndView();
        List<Student> students = studentService.list(studentpage);

        int total = studentService.total();

        logger.info("total : "+total);

        studentpage.caculateLast(total);

        logger.info("首页 ： " + studentpage.getStart());
        logger.info("上一页 ： " + studentpage.getPrevious());
        logger.info("下一页 ：" + studentpage.getNext());
        logger.info("末页 ：" + studentpage.getLast());
        logger.info("页数" + studentpage.getCount());

        mav.addObject("students",students);

        mav.addObject("studentpage",studentpage);

        mav.setViewName("listStudent");

        return mav;
    }



    @PutMapping("/student")
    public ModelAndView addStudent(Student student){

        logger.debug("student.getName():"+student.getName());

        studentService.add(student);

        logger.debug(student);

        ModelAndView mav = new ModelAndView("redirect:/student");

        return mav;
    }

    @DeleteMapping("/student/{id}")
    public ModelAndView deleteStudent(Student student){
        studentService.delete(student);

        ModelAndView mav = new ModelAndView("redirect:/student");

        return mav;
    }

    @GetMapping("/student/{id}")
    public ModelAndView editStudent(Student student){

        logger.debug("edit");

        Student student1 = studentService.get(student.getId());

        logger.debug(student1);
        ModelAndView mav = new ModelAndView("editStudent");

        mav.addObject("student1",student1);

        return mav;
    }

    @PostMapping("/student/{id}")
    public ModelAndView updateStudent(Student student){

        logger.debug("update");

        logger.debug(student);
        studentService.update(student);

        ModelAndView mav = new ModelAndView("redirect:/student");

        return mav;
    }
}
