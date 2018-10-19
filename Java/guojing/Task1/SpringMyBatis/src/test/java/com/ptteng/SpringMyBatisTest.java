package com.ptteng;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//用Spring管理的项目，在不启动服务的情况下进行测试类测试
@ContextConfiguration(locations = "classpath:applicationcontext.xml")
//ContextConfiguration Spring整合JUnit4测试时，使用注解引入多个配置文件
@RunWith(SpringJUnit4ClassRunner.class)
//RunWith是一个运行器。RunWith(JUnit4.class)就是指用JUnit4来运行
//RunWith(SpringJUnit4ClassRunner.class),让测试运行于Spring测试环境

public class SpringMyBatisTest {
    static Logger logger = Logger.getLogger(SpringMyBatisTest.class);
    @Autowired
    Mapper mapper;

    @Test
    public void insertTest() {
        User user = new User();
        user.setName("张生");
        user.setQQ(666002485);
        user.setWish("好好学习");
        user.setCreateAt(System.currentTimeMillis());
        user.setUpdateAt(System.currentTimeMillis());
        mapper.insertUser(user);
        logger.debug(user.getId());
    }

    @Test
    public void findAllTest() {
        logger.debug(mapper.findAll());
          }

    @Test
    public void findByIdTest() {
        logger.debug(mapper.findById(10));
            }

    @Test
    public void updateTest() {
        User user = new User();
        user.setName("韩梅梅");
        user.setQQ(635874952);
        user.setWish("天天向上");
        user.setCreateAt(System.currentTimeMillis());
        user.setUpdateAt(System.currentTimeMillis());
        user.setId(11);
        logger.debug(mapper.updateUser(user));
    }

    @Test
    public void deleteTest() {
        logger.debug(mapper.deleteUser(37));
    }

}
