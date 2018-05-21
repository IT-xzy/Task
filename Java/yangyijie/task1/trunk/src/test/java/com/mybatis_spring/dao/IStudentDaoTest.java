package com.mybatis_spring.dao;

import com.mybatis_spring.bean.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Calendar;

/**
 * @author Arike
 * Create_at 2017/12/1 15:58
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/mybatis_spring/dao/mybaits-spring.xml")
public class IStudentDaoTest {
    @Autowired
    ApplicationContext ctx;
    @Autowired
    IStudentDao studentDao;
    @Test
    public void getStudentById() throws Exception {
        System.out.println(studentDao.getStudentById(11L));
    }
    
    @Test
    public void getStudentByName() throws Exception {
        System.out.println(studentDao.getStudentByName("金"));
    }
    
    @Test
    public void updateStudent() throws Exception {
        Student s = new Student();
        s.setId(10L);
        s.setUpdate_at(System.currentTimeMillis()/1000);
        s.setName("ask觉得撒");
        studentDao.updateStudent(s);
    }
    
    @Test
    public void insertStudent() throws Exception {
        Long creat_at = System.currentTimeMillis()/1000;
        Calendar calendar =Calendar.getInstance();
        calendar.set(2017,12,10,10,30,0);
        studentDao.insertStudent(new Student(creat_at,creat_at,"何人","4456","火星",calendar.getTimeInMillis()/1000,"盲人技校","Java001","www.baidu.com","成为BUG书写员","杨以杰","翻墙过来的"));
    }
    
    @Test
    public void deleteStudent() throws Exception {
        studentDao.deleteStudent(new Long[]{12L,13L});
    }
}