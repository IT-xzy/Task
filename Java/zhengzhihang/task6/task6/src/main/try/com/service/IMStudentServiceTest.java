package com.service;

import com.dao.StudentMapper;
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
    IMStudentService imStudentService;

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    private IFStudentService ifStudentService;

    private static Logger logger=Logger.getLogger(IMStudentService.class);
    private Student student;


    @Test
    public void  test2(){
        student=ifStudentService.findStudentById(1);
        logger.info(student);
    }
    @Test
    public void findStudentById() {
        student=imStudentService.findStudentById(1);
        logger.info(student);
    }

    @Test
    public void findStudentByName() {
        student=imStudentService.findStudentByName("一");
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
        imStudentService.inputStudent(student);
    }

    @Test
    public void outputStudentById() {
        imStudentService.outputStudentById(6);
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
        imStudentService.replayStudent(student);

    }

    @Test
    public void findStudent() {
        List<Student> students;
        students=imStudentService.findStudent();
        logger.info(students);
    }

    @Test
    public void find(){
        student=studentMapper.selectStudentById(333);
        System.out.println(student);
    }
}