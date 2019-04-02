package com.jnshu.controller;

import com.jnshu.pojo.Student;
import com.jnshu.service.StudentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author pipiretrak
 * @date 2019/3/30 - 7:25
 */
@Controller
public class StudentController {
    private static Logger logger = Logger.getLogger(StudentController.class);

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView getAll(){
        List<Student> students =studentService.getAll();
        logger.info(students.toString());
        ModelAndView mav =new ModelAndView("home");
        mav.addObject("students",students);
        return mav;
    }


}
