package com.jnshu.dao.impl;

import com.jnshu.dao.StudentDao;
import com.jnshu.pojo.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author pipiretrak
 * @data 2018/12/30 - 9:29
 */

@ContextConfiguration(locations = "classpath:ApplicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class StudentDaoImplTest {
    @Resource(name = "studentDao")
    private StudentDao studentDao;

    @Test
    public void addStudent()  {
        Student student = new Student();
        student.setName("小徐");
        student.setQq("258083248");
        student.setType("Java");
        student.setEnrolmentTime(20181202);
        student.setSchool("广西大学");
        student.setOnlineId(5064);
        student.setDailyUrl("www.jnshu.com");
        student.setWish("长胖");
        student.setBrother("唐海清");
        student.setWhereToKnowJnshu("知乎");
        student.setcreateAt(20181202);
        student.setupdateAt(20181229);
        studentDao.addStudent(student);
        System.out.println(student);
    }

    @Test
    public void deleteStudent() {
        Student student = new Student();
        studentDao.deleteStudent(990021);
    }

    @Test
    public void updateStudent() {
        Student student = new Student();
        student.setName("师弟");
        student.setId(990022);
        studentDao.updateStudent(student);
    }

    @Test
    public void findByIdAndName() {
        Student student = studentDao.findByIdAndName(990022,"师弟");
        if (null != student) {
            System.out.println(student.toString());

        }
    }

    @Test
    public void findAll() {
        List<Student> list = studentDao.findAll();
        for (Student student :list){
            System.out.println(student.toString());
        }
    }
}