package com.jns.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class StudentDaoTest {

    @Autowired
    StudentDao studentDao;
    
    @Test
    public void selectAll() {
    }

    @Test
    public void selectPhoneNum() {
    }

    @Test
    public void selectStuName() {
    }

    @Test
    public void selectStuID() {
    }

    @Test
    public void selectWithNameIDPhoneNumPassWord() {
    }

    @Test
    public void signUpStudent() {
    }

    @Test
    public void updateLoginTime() {
    }

    @Test
    public void updateStudent() {
    }

    @Test
    public void countAll() {
        int a=studentDao.countAll();
        System.out.println("a = " + a);
    }

    @Test
    public void countJob() {
    }

    @Test
    public void countCourse() {
    }

    @Test
    public void findGood() {
    }

    @Test
    public void deleteAll() {
    }
}