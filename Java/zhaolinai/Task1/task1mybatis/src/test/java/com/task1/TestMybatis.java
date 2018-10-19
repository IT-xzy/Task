package com.task1;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;


import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;


public class TestMybatis {
    private static Logger logger;
    private static SqlSession session;
    private static StudentDao dao;

    @BeforeClass
    public static void setSession() {
        logger = Logger.getLogger(TestMybatis.class);
        InputStream is = TestMybatis.class.getClassLoader().getResourceAsStream("conf.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        session = sqlSessionFactory.openSession(true);
        dao = session.getMapper(StudentDao.class);
    }

    @Test
    public void testShowAll() throws SQLException {

        List list = dao.showAll();
        session.close();
        logger.debug(list);
    }

    @Test
    public void testShowOneN() throws SQLException {
        List list = dao.showOneN("赵立鼐");
        session.close();
        logger.debug(list);

    }

    @Test
    public void testShowOneI() throws SQLException {
        Student student = dao.showOneI("001");

        session.close();
        logger.debug(student);
    }

    @Test
    public void testAdd() throws SQLException {
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
        session.close();
        logger.debug(student.getId());

    }

    @Test
    public void testDelete() throws SQLException {
        logger.debug(dao.delete(22));
        session.close();
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
