package com.task1;

import com.task1.dao.Connector;
import com.task1.dao.StudentDao;
import com.task1.entity.Student;
import com.task1.impl.StudentDaoImpl;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;


public class jdbcTest {
   private static Logger logger;
   private static  Student student;
   private  static StudentDao dao;

   @BeforeClass
           public static void before(){
        logger=Logger.getLogger(jdbcTest.class);
         dao = new StudentDaoImpl();
   }


    @Test
    public void conn() throws SQLException {

        Connection connection = Connector.getConnection();
        logger.debug(connection);
        connection.close();
    }

    @Test
    public void addTest() throws SQLException {

        student =new Student();
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
    public void deleteTest() throws SQLException {

       logger.debug(dao.delete(23));

    }

    @Test
    public void updateTest() throws SQLException {

       student=new Student();
        student.setCreate_at(System.currentTimeMillis());
        student.setUpdate_at(System.currentTimeMillis());
        student.setName("吕卓凯");
        student.setQq(1232315);
        student.setCurricular("java");
        student.setSchool_time("2018年07月10日");
        student.setCollege("蓝翔技术学院");
        student.setId_num("005");
        student.setReport_link("http://www.jnshu.com/school/28015/daily");
        student.setGoal("天天积极");
        student.setRefree("阿达哈哈");

        logger.debug(dao.update(student));
    }
    @Test
    public void showTest() throws SQLException {

       logger.debug(dao.showOneN("赵立鼐"));
    }

    @Test
    public void showOneTest() throws SQLException {

       logger.debug(dao.showOneI("3043"));
    }
    @Test
    public void showAllTest() throws SQLException {

       logger.debug(dao.showAll());
    }
}
