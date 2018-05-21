package com.controller;

import com.mapper.StudentMapper;
import com.pojo.Student;
import com.service.InStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class AddStudentController {
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    private InStudent inStudent;
    @Autowired
    private Student student;

    @RequestMapping(value = "/student",method = RequestMethod.GET)
    public String showaddstudent() {
        return "addstudent";
    }

    @RequestMapping(value = "/student",method = RequestMethod.POST)
    public String addstudent(
            @RequestParam("name") String name,
            @RequestParam("qq") String qq,
            @RequestParam("class_id") int class_id,
            @RequestParam("graduate_school") String graduate_school,
            @RequestParam("oline_number") String oline_number,
            @RequestParam("link") String link,
            @RequestParam("wish") String wish,
            @RequestParam("brother_id") int brother_id
    ) throws Exception {
        Logger logger = (Logger) LoggerFactory.getLogger(AddStudentController.class);
        logger.info("/addstudent post");
        //ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
        //StudentMapper studentMapper = (StudentMapper) context.getBean("studentMapper");
        //Student student = new Student();
        student.setName(name);
        student.setQq(qq);
        student.setClass_id(class_id);
        student.setGraduate_school(graduate_school);
        student.setOline_number(oline_number);
        student.setLink(link);
        student.setWish(wish);
        student.setBrother_id(brother_id);
        //InStudent inStudent = new InStudent();
        inStudent.setStudentMapper(studentMapper);
        inStudent.doSomeBusinessStuff(student);

        return "redirect:/";
    }
}



