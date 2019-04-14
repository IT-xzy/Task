package com.jnshu;

import org.apache.log4j.Logger;
import org.junit.Test;

public class StudentTest {
    static Logger logger = Logger.getLogger(StudentTest.class);
    static StudentDao dao = new StudentImp();
    static Student s = new Student();

    @Test
    public void add() {
        s.setName("毛毛");
        s.setQq(1744207827);
        s.setType("JAVA工程师");
        s.setAdmission_date("2018年12月27日");
        s.setGraduate_school("北京大学");
        s.setStudent_number(1234);
        s.setDaily_link("http://www.jnshu.com/school/29862/daily?page=12");
        s.setWish("好好学习天天向上");
        s.setInstructor("郭靖");
        s.setInformation_source("朋友");
        logger.info(dao.add(s));
    }
    @Test
    public void delete(){
        logger.info(dao.delete(10));
    }
    @Test
    public void update(){
        s.setName("孙小毛");
        s.setQq(1744207827);
        s.setType("JAVA工程师");
        s.setAdmission_date("2018年12月27日");
        s.setGraduate_school("北京大学");
        s.setStudent_number(1234);
        s.setDaily_link("http://www.jnshu.com/school/29862/daily?page=12");
        s.setWish("好好学习天天向上");
        s.setInstructor("卤泊梁");
        s.setInformation_source("朋友");
        s.setId(9);
        logger.info(dao.update(s));
    }
    @Test
    public void findAll(){
        logger.info(dao.findAll());

    }
    @Test
    public void findById(){
        logger.info(dao.findById(2));
    }
}
