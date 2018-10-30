package com.jnshu.mybatis.dao;

import com.jnshu.mybatis.pojo.User1;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = "classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDao1Test {
    @Autowired
    private UserDao1 userDao1;
    //@Before
    //private Logger log() {
    //    Logger logger = Logger.getLogger("log4j.properties");
    //    return logger;
    //}

    @Test
   public void getUser() {

        //log().warning("........");
        System.out.println( userDao1.getUser(1));

    }
    @Test
   public void deleteUser() {
        //log().info("测试结果:");
        userDao1.deleteUser(10);
    }
    @Test
   public void updateUser() {
        //log().info("测试结果:");
        User1 user1 = new User1();
        user1.setName("tanghaiqing");
        user1.setAge(20);
        user1.setGender("men");
        user1.setSalary(102);
        user1.setId(5);
        userDao1.updateUser(user1);
    }
    @Test
   public void insertUser() {
        //log().info("测试结果:");
        User1 user1 = new User1();
        //user1.setId(3);
        user1.setName("haiqing");
        user1.setAge(22);
        user1.setGender("men");
        user1.setSalary(00);
        userDao1.insertUser(user1);
    }
}