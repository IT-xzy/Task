package com.DAO;

import com.Student.Student;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import java.util.List;

import static org.junit.Assert.*;

public class StudentMapperTest {
    StudentMapper studentMapper=null;
    List<Student> studentList=null;
    Student studnet=new Student();
    boolean operation=false;
    private static Logger logger=Logger.getLogger(Test.class);
    @Before
    public void BeforeTest(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
        studentMapper=(StudentMapper) ac.getBean("studentMapper");
    }

    @Test
    public void findStudentById() {
        studnet=studentMapper.findStudentById(18);
        logger.info(studnet.toString());
    }

    @Test
    public void findStudentByname() {
        studentList=studentMapper.findStudentByname("小明");
        logger.info(studentList);
    }

    @Test
    public void addStudent() {
        studnet.setName("小明");
        studnet.setAge(25);
        studnet.setQq("546346248");
        studentMapper.addStudent(studnet);
        logger.info("主键是"+studnet.getId());
    }

    @Test
    public void deleteStudnetById() {
        operation=studentMapper.deleteStudnetById(2);
        logger.info(operation);
    }

    @Test
    public void updateStudnetById() {
        studnet.setName("小明");
        studnet.setAge(25);
        studnet.setQq("546346248");
        studnet.setId(2);
        operation=studentMapper.updateStudnet(studnet);
        logger.info(operation);
    }

    @Test
    public void selectAllStudent() {
        studentList=studentMapper.selectAllStudent();
        logger.info(studentList);
    }
}