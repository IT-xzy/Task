package com.mojorjoe.web;

import com.mojorjoe.web.pojo.PageBean;
import com.mojorjoe.web.pojo.Student;
import com.mojorjoe.web.service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Action {
    ApplicationContext act = new ClassPathXmlApplicationContext("SpringApplication.xml");
    StudentService studentService = (StudentService) act.getBean("serviceImpl");

    Student student=new Student();

    PageBean pageBean = new PageBean();

    long save() throws Exception {
        student.setName("了li");
        return studentService.saveStudent(student);
    }

    PageBean list()throws Exception{
        return  studentService.pageListStudent(20,5);
    }





    public static void main(String[] args) throws Exception {
        Action action= new Action();
        System.out.println(action.save());
        System.out.println(action.list());


    }
}
