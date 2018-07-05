package com.dao;

import com.pojo.Student;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class StudentMapperTest {

    private static Logger logger = Logger.getLogger(StudentMapperTest.class);
    @Autowired
    private StudentMapper sm;
    private int i;
    private Student student;
    @Test
    public void selectStudentById() {
        student=new Student();
        student=sm.selectStudentById(1);
        logger.info(student);
    }

    @Test
    public void selectStudentByName() {
        student=new Student();
        student=sm.selectStudentByName("一");
        logger.info(student);
    }

    @Test
    public void insertStudent() {
        student=new Student();
        student.setAge("4");
        student.setId(4);
        student.setSex("1");
        student.setSchool("复旦");
        student.setName("四");
        logger.info("插入后当前数据的id值是："+student.getId());
    }

    @Test
    public void deleteStudentById() {
        sm.deleteStudentById(4);
    }

    @Test
    public void updateStudentById() {
        student=new Student();
        student.setAge("3");
        student.setId(3);
        student.setSex("1");
        student.setSchool("复旦");
        student.setName("三");
        sm.updateStudentById(student);
        logger.info("当前数据的id值是："+student.getId());

    }

    @Test
    public void selectStudent(){
        List<Student> students;
        students=sm.selectStudent();
        logger.info(students);


    }
}