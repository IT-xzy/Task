package com.jnshu;


import org.apache.log4j.Logger;
import org.junit.Test;

public class JdbcTest {
    static Logger logger = Logger.getLogger(StudentTest.class);
    Student student = new Student();
    StudentTest s = new StudentTest();

    @Test
    public void add() {
        student.setName("孙若飞");
        student.setQq(1744207827);
        student.setType("JAVA工程师");
        student.setAdmission_date("2018年12月27日");
        student.setGraduate_school("北京大学");
        student.setStudent_number(1234);
        student.setDaily_link("http://www.jnshu.com/school/29862/daily?page=12");
        student.setWish("好好学习天天向上");
        student.setInstructor("郭靖");
        student.setInformation_source("朋友");
        logger.info(s.add(student));

    }

    @Test
    public void delete() {
        logger.info(s.delete(3));
    }

    @Test
    public void update() {
        student.setName("孙大毛");
        student.setQq(1744207827);
        student.setType("JAVA工程师");
        student.setAdmission_date("2019年12月27日");
        student.setGraduate_school("清华大学");
        student.setStudent_number(1234);
        student.setDaily_link("http://www.jnshu.com/school/29862/daily?page=12");
        student.setWish("好好学习天天向上");
        student.setInstructor("卤泊梁");
        student.setInformation_source("朋友介绍");
        student.setId(5);
        logger.info(s.update(student));
    }

    @Test
    public void findAll() {
        logger.info(s.findAll());

    }

@Test
    public void findById(){
        logger.info(s.findById(2));

}


}
