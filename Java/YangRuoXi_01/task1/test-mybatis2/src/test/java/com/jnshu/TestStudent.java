package com.jnshu;

import com.jnshu.beans.Student;
import com.jnshu.service.impl.StudentServiceImpl;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestStudent {

    Logger logger = Logger.getLogger(TestStudent.class);
    @Autowired
    StudentServiceImpl studentService;


    @Before
    public void testBefore() {
        logger.info("Test Start");
    }

    @After
    public void testAfter() {
        logger.info("Test End");
    }

    @Test
    public void testSelectAll() {
        Long startTime = System.currentTimeMillis();
        Student student= null;
        try {
            student = studentService.selectStuAll();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("SelectFailed ");
        }
        logger.info(student);
        logger.info(System.currentTimeMillis() - startTime);

    }

    @Test
    public void testSelectStuById() {
        Long startTime = System.currentTimeMillis();
        Student student = null;
        try {
            student = studentService.selectStuById(1);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("SelectFailed ");
        }
        logger.info(student);
        logger.info(System.currentTimeMillis() - startTime);
    }

    @Test
    public void testSelectByName() {
        Long startTime = System.currentTimeMillis();
        Student student = null;
        try {
            student = studentService.selectStuByName("yangruoxi");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("SelectFailed ");
        }
        logger.info(student);
        logger.info( System.currentTimeMillis() - startTime);
    }

    @Test
    public void testSelectByOnlineNumber() {
        Long startTime = System.currentTimeMillis();
        Student student = null;
        try {
            student = studentService.selectStuByOnlineNumber(51460);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("SelectFailed ");
        }

        logger.info(student);
        logger.info( System.currentTimeMillis() - startTime);
    }
    @Test
    public void  testAdd() {
        Long startTime = System.currentTimeMillis();
        Student student = new Student();
        student.setName("teststu");
        student.setQq(111111);
        student.setOnlineNumber(7777);
        student.setLink("www.baidu.com");
        student.setSchool("ncut");
        student.setTeacher("zjz");
        student.setTime("123321");
        student.setType("java");
        student.setWhereKonw("bihu");
        student.setWish("upup");
        try {
            studentService.addStu(student);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("addFailed ");
        }
        logger.info("success");
        logger.info( System.currentTimeMillis() - startTime);

    }



    @Test
    public void testdelStu() {
        boolean i = false;
        try {
            i = studentService.delStuById(999);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("deleteFailed");
        }
        logger.info("success");
        logger.info(i);
    }

    @Test
    public void testUpdate() {
        Long time = System.currentTimeMillis();
        boolean i = false;
        try {
            i = studentService.updateStuTypeById(3,"web",time);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("UpdateFailed");
        }
        logger.info("success");
        logger.info(i);
    }


}
