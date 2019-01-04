package com.lyh.controller;

import com.lyh.entity.Student;
import com.lyh.page.Page;
import com.lyh.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StudentController {
    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public ModelAndView listStudent(Page page) {
        logger.info("listStudent方法被调用");
        ModelAndView mav = new ModelAndView();
        List<Student> students = studentService.listPageStudent(page);
        int total = studentService.total();
        page.caculateLast(total);
        mav.addObject("students", students);
        mav.setViewName("listStudent");
        return mav;
    }

    @RequestMapping(value = "/u/student", method = RequestMethod.GET)
    public String addStudent() {
        logger.warn("跳转添加页面");
        return "addStudent";
    }
    @RequestMapping(value = "/u/student", method = RequestMethod.POST)
    public ModelAndView addStudent(@Validated Student student, BindingResult result) {
        logger.info("添加方法被调用");
        if (result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();
            for (ObjectError error : errors) {
                logger.warn(error.getDefaultMessage());
            }
        }
        if (student.getStudentNumber()== null){
            logger.warn("添加出现错误");
            ModelAndView mav = new ModelAndView("redirect:/u/student");
           return mav;
        }
      int x = studentService.addStudent(student);
      logger.info("添加结果："+String.valueOf(x));
        ModelAndView mav = new ModelAndView("redirect:/student");
         mav.addObject("student", student);
        return mav;
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
    public ModelAndView deleteStudent(@PathVariable Long id) {
        logger.info("删除方法被调用");
        logger.info(String.valueOf(id));
        long x = studentService.deleteStudent(id);
        logger.info("删除数据的id:"+String.valueOf(x));
        ModelAndView mav = new ModelAndView("redirect:/student");
        return mav;
    }

//    根据id查询数据
    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
    public ModelAndView editStudent(@PathVariable Long id) {
        logger.warn("根据id查询数据");
        Student student = studentService.getStudent(id);
        logger.warn("根据id查询数据结果："+student);
        ModelAndView mav = new ModelAndView();
        mav.addObject("student", student);
        mav.setViewName("editStudent");
        logger.warn(String.valueOf(student));
        return mav;
    }

    @RequestMapping(value = "/student", method = RequestMethod.PUT)
    public ModelAndView updateStudent(Student student) {
        logger.info(String.valueOf(student));
        logger.info("修改方法被调用");
        studentService.updateStudent(student);
        logger.info(String.valueOf(student));
        ModelAndView mav = new ModelAndView("redirect:/student");
        mav.addObject("student", student);
        return mav;
    }
    @RequestMapping(value = "/student/name/",method= RequestMethod.GET)
    public ModelAndView byName(@RequestParam String name){
        logger.warn("调用模糊查询");
        logger.warn("查询名字："+name);
        List<Student> students = studentService.byName(name);
        logger.warn("模糊查询结果："+String.valueOf(students));
        ModelAndView mav = new ModelAndView();
        mav.addObject("students",students);
        mav.setViewName("studentJson");
        logger.warn(String.valueOf(mav));
        return mav;
    }
}