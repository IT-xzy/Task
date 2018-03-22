package com.controller;

import com.mapper.StudentMapper;
import com.pojo.Student;
import com.service.GetStudent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GetStudentController {
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    GetStudent getStudent;
    public Student studentModel(int id) throws Exception {
        //ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
        //StudentMapper studentMapper = (StudentMapper) context.getBean("studentMapper");
        //GetStudent getStudent = new GetStudent();
        getStudent.setStudentMapper(studentMapper);
        Student student = getStudent.doSomeBusinessStuff(id);
        return student;
    }
    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
    public ModelAndView student(@PathVariable int id) throws Exception {
        Logger logger = (Logger) LoggerFactory.getLogger(AddStudentController.class);
        logger.info("/getstudent/{id}");
        Student student =  studentModel(id);
        return new ModelAndView("showstudent","student",student);
    }
}
