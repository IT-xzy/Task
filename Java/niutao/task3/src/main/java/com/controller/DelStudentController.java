package com.controller;

import com.mapper.StudentMapper;
import com.pojo.Student;
import com.service.DelStudent;
import com.service.GetStudent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DelStudentController {
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    DelStudent delStudent;

    @RequestMapping(value = "/delstudent/{id}", method = RequestMethod.GET)
    public String delstudent(@PathVariable int id) throws Exception {
        Logger logger = (Logger) LoggerFactory.getLogger(AddStudentController.class);
        logger.info("/delstudent");
        //ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
        //StudentMapper studentMapper = (StudentMapper) context.getBean("studentMapper");
        //DelStudent delStudent = new DelStudent();
        delStudent.setStudentMapper(studentMapper);
        try {
            delStudent.doSomeBusinessStuff(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }
}




