package com.jnshu.dao;

import com.jnshu.pojo.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @author pipiretrak
 * @date 2019/1/9 - 10:28
 */
@ContextConfiguration(locations = "classpath:SpringMybatis.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class StudentDaoTest {
    @Resource(name = "studentDao")
    private StudentDao studentDao;

    @Test
    public void testAdd(){
        Student student = new Student();
        student.setName("李白");
        student.setQq("441207082");
        student.setType("Web");
        student.setEnrolmentTime(20181104);
        student.setSchool("中山大学");
        student.setOnlineId(5064);
        student.setDailyUrl("www.jnshu.com");
        student.setWish("长胖");
        student.setBrother("唐海清");
        student.setWhereToKnowJnshu("知乎");
        student.setcreateAt(20181115);
        student.setupdateAt(20181117);
        studentDao.add(student);
        System.out.println("新增id:"+student.getId());
    }
}
