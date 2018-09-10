package com.task1;

import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;


public class Test1 {
    private static Logger logger;
    private static StudentDao dao;

    @BeforeClass
    public static void getDao() {
        logger = Logger.getLogger(Test1.class);
        ApplicationContext a = new ClassPathXmlApplicationContext("spring.xml");
        dao = (StudentDao) a.getBean("studentDao");

    }

    @Test
    public void testShowAll() throws SQLException {
        logger.debug(dao.showAll());
    }

    @Test
    public void testShowOneN() throws SQLException {
        logger.debug(dao.showOneN("赵立鼐"));
    }

    @Test
    public void testShowOneI() throws SQLException {
        logger.debug(dao.showOneI("001"));
    }

    @Test
    public void testInset() throws SQLException {
        Student student = new Student();
        student.setCreate_at(System.currentTimeMillis());
        student.setUpdate_at(System.currentTimeMillis());
        student.setName("金石开");
        student.setQq(1050376715);
        student.setCurricular("产品经理");
        student.setSchool_time("2018年07月10日");
        student.setCollege("北京师范大学");
        student.setId_num("1359");
        student.setReport_link("http://www.jnshu.com/school/28015/daily");
        student.setGoal("好好学习");
        student.setRefree("李天宇");
        dao.add(student);
        logger.debug(student.getId());
    }

    @Test
    public void testDelete() throws SQLException {
        logger.debug(dao.delete(16));
    }

    @Test
    public void testUpdate() throws SQLException {
        Student student = new Student();
        student.setCreate_at(System.currentTimeMillis());
        student.setUpdate_at(System.currentTimeMillis());
        student.setName("吕卓凯");
        student.setQq(1232315);
        student.setCurricular("java");
        student.setSchool_time("2018年07月10日");
        student.setCollege("蓝翔技术学院");
        student.setId_num("001");
        student.setReport_link("http://www.jnshu.com/school/28015/daily");
        student.setGoal("天天向上");
        student.setRefree("阿达");
        student.setId(2);
        logger.debug(dao.update(student));

    }


}
