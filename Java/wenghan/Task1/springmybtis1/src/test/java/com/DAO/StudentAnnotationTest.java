package com.DAO;

import com.Student.Student;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

public class StudentAnnotationTest {

    StudentAnnotation studentAnnotation=null;
    List<Student> studentList=null;
    Student studnet=new Student();
    boolean operation=false;
    private static Logger logger=Logger.getLogger(Test.class);
    @Before
    public void BeforeTest(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
        studentAnnotation=(StudentAnnotation)ac.getBean("StudentAnnotation");
    }

    @Test
    public void insertStudent() {
        studnet.setName("小明");
        studnet.setAge(25);
        studnet.setQq("546346248");
        studentAnnotation.insertStudent(studnet);
        long i=studnet.getId();
        logger.info("主键是"+i);
    }

    @Test
    public void updateStudent() {
        studnet.setName("小明");
        studnet.setAge(25);
        studnet.setQq("******");
        studnet.setId(3);
        operation=studentAnnotation.updateStudent(studnet);
        logger.info(studentAnnotation.findStudentById(3).toString());
        logger.info(operation);
    }

    @Test
    public void deleteStudent() {
        operation=studentAnnotation.deleteStudent(19);
        logger.info(operation);
    }

    @Test
    public void findStudentById() {
        studnet=studentAnnotation.findStudentById(3);
        logger.info(studnet);
    }
}