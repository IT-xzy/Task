package com.service;

import com.pojo.Student;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-mybatis.xml")
public class IMStudentServiceTest {
    @Autowired
    ServiceImpl1 serviceImpl1;

    @Autowired
    private Service1 service1;

    private static Logger logger=Logger.getLogger(IMStudentServiceTest.class);
    private Student student;


    @Test
    public void  test2(){
        student=service1.findStudentById(1);
        logger.info(student);
    }
    @Test
    public void findStudentById() {
        student=serviceImpl1.findStudentById(1);
        logger.info(student);
    }

    @Test
    public void findStudentByName() {
        student=serviceImpl1.findStudentByName("一");
        logger.info(student);
    }

    @Test
    public void inputStudent() {
        student=new Student();
        student.setName("test1");
        student.setSchool("test1");
        student.setSex("1");
        student.setAge("33");
        System.out.println(student);
        serviceImpl1.inputStudent(student);
    }

    @Test
    public void outputStudentById() {
        serviceImpl1.outputStudentById(6);
    }

    @Test
    public void replayStudent() {
        student=new Student();
        student.setName("test1");
        student.setSchool("test1");
        student.setSex("1");
        student.setAge("33");
        student.setId(19);
        student.setUpdate_at(System.currentTimeMillis());
        serviceImpl1.replayStudent(student);

    }

    @Test
    public void findStudent() {
        List<Student> students;
        students=serviceImpl1.findStudent();
        logger.info(students);
    }
}