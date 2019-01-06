package com.jnshu;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@ContextConfiguration("classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class StudentTest {
    @Autowired
    StudentMapper mapper;
    Student student = new Student();
    static Logger logger = Logger.getLogger(StudentTest.class);

    @Test
    public void add() {
        student.setName("老张");
        student.setQq(1744207827);
        student.setType("JAVA工程师");
        student.setAdmission_date("2018年12月20日");
        student.setGraduate_school("家里蹲大学");
        student.setStudent_number(1234);
        student.setDaily_link("http://www.jnshu.com/school/29862/daily?page=12");
        student.setWish("好好学习天天向上");
        student.setInstructor("白洁");
        student.setInformation_source("朋友");
        mapper.add(student);
        logger.info(student.getId());
    }

    @Test
    public void delete() {
        logger.info(mapper.delete(13));
    }

    @Test
    public void update() {
        student.setName("老王");
        student.setQq(1744207827);
        student.setType("JAVA工程师");
        student.setAdmission_date("2018年12月20日");
        student.setGraduate_school("家里蹲大学");
        student.setStudent_number(1234);
        student.setDaily_link("http://www.jnshu.com/school/29862/daily?page=12");
        student.setWish("好好学习天天向上");
        student.setInstructor("白洁");
        student.setInformation_source("朋友");
        student.setId(12);
        logger.info(mapper.update(student));

    }

    @Test
    public void findAll() {
        logger.info(mapper.findAll());

    }

    @Test
    public void findById() {
        logger.info(mapper.findById(2));
    }

}
