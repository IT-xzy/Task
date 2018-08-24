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
@ContextConfiguration(locations = "classpath:spring-mybatis.xml")
public class StudentMapperTest {

    private static Logger logger = Logger.getLogger(StudentMapperTest.class);
    @Autowired
    private StudentMapper sm;
    private long i;
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
        student=sm.selectStudentByName("老一");
        logger.info(student);
    }

    @Test
    public void insertStudent() {
        student=new Student();
        student.setAge("88");
//        student.setId(5);
        student.setSex("girl");
        student.setSchool("清华");
        student.setName("事儿");
        student.setCreate_at(System.currentTimeMillis());
//        student.setUpdate_at(System.currentTimeMillis());
        sm.insertStudent(student);
        logger.info("插入后当前数据的id值是："+student.getId());
    }

    @Test
    public void deleteStudentById() {
        sm.deleteStudentById(10);
    }

    @Test
    public void updateStudentById() {
        student=new Student();
        student.setAge("3");
        student.setId(3);
        student.setSex("man");
        student.setSchool("社会大学");
        student.setName("散散");
        student.setUpdate_at(System.currentTimeMillis());
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