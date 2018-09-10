package com.ptteng;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

public class JdbcTest {
    static Logger logger = Logger.getLogger(JdbcTest.class);
    private Jdbc jdbc;

    @Before
    public void test() {
        jdbc = new Jdbc();
    }

    @Test
    public void insertTest() throws SQLException, ClassNotFoundException {
        User user = new User();
        user.setName("郭杰");
        user.setQQ(601889774);
        user.setWish("好好学习");
        user.setCreateAt(System.currentTimeMillis());
        user.setUpdateAt(System.currentTimeMillis());
        logger.debug(jdbc.insertUser(user));

    }


    @Test
    public void findAllTeset() throws SQLException, ClassNotFoundException {
        logger.debug(jdbc.findAll());
    }


    @Test
    public void findByIdTest() throws SQLException, ClassNotFoundException {
        logger.debug(jdbc.findById(3));
    }


    @Test
    public void updateTest() throws SQLException, ClassNotFoundException {
        User user = new User();
        user.setName("曹操");
        user.setQQ(163568998);
        user.setWish("天天向上");
        user.setCreateAt(System.currentTimeMillis());
        user.setUpdateAt(System.currentTimeMillis());
        user.setId(5);
        logger.debug(jdbc.updateUser(user));
    }


    @Test
    public void deleteTeset() throws SQLException, ClassNotFoundException {
        logger.debug(jdbc.deleteUser(33));
    }
}
