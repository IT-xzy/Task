package com.task1;

import com.task1.dao.StudentDao;
import com.task1.entity.Student;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


public class TestJdbcTemplate {
    private static Logger logger;
    private static StudentDao dao;
    private Student student;
    @BeforeClass
    public static void testLog4j(){
        logger= Logger.getLogger( TestJdbcTemplate.class);
        ApplicationContext a=new ClassPathXmlApplicationContext("spring.xml");
         dao = (StudentDao) a.getBean("studentDao");
    }

    @Test
    public void testDatasource() throws SQLException {
        ApplicationContext a = new ClassPathXmlApplicationContext("spring.xml");
        DataSource dataSource = (DataSource) a.getBean("dataSource");
        Connection connection= dataSource.getConnection();
        logger.debug(connection);
        connection.close();
    }
    @Test
    public   void testAdd() throws SQLException {

        student = new Student();
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
        logger.debug(dao.add(student));
    }
    @Test
    public void testDelet() throws SQLException {
        logger.debug(dao.delete(26));
    }

    @Test
    public void testUpdate() throws SQLException {
        student=new Student();
        student.setCreate_at(System.currentTimeMillis());
        student.setUpdate_at(System.currentTimeMillis());
        student.setName("金石开");
        student.setQq(1050376715);
        student.setCurricular("产品经理");
        student.setSchool_time("2018年07月10日");
        student.setCollege("北京师范大学");
        student.setId_num("001");
        student.setReport_link("http://www.jnshu.com/school/28015/daily");
        student.setGoal("好好学习");
        student.setRefree("李天宇");

          logger.debug(dao.update(student));
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
    public void testShowAll() throws SQLException {
        logger.debug(dao.showAll());
    }
}
