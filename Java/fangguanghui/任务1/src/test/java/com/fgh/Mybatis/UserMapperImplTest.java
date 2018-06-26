package com.fgh.Mybatis;

import com.fgh.Mybatis.Tool.TimeReversal;
import com.fgh.Mybatis.dao.UserMapper;
import com.fgh.Mybatis.model.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

public class UserMapperImplTest {
    private ApplicationContext applicationContext;

    @Before
    public void step() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    }

    @Test
    public void testFinderUserById() throws Exception {
        UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");
        User user = new User();
        user.setType("java");
        List <User> users = userMapper.findUserBy(user);
        System.out.println(users);
    }

    @Test
    public void testInsertUser() throws Exception {
        User user = new User();
        user.setUsername("吴旷");
        user.setQQ("201805201126");
        user.setType("web");
        user.setDescription("电饭锅");
        user.setCreate_at(TimeReversal.Datetolong(new Date()));
        UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");
        userMapper.insertUser(user);
   }
    @Test
    public void testDelUser()throws Exception {
        UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");
        userMapper.delUser(4);
    }
    @Test
    public void testUpdate()throws Exception{
        User user = new User();
        user.setId(2);
        user.setUsername("卡卡");
        user.setQQ("201805201126");
        user.setCounsellor("李莉");
        user.setDescription("电饭锅");
        user.setUpdate_at(TimeReversal.Datetolong(new Date()));
        UserMapper userMapper=(UserMapper)applicationContext.getBean("userMapper");
        Boolean UpdateBool = userMapper.updateUser(user);
        System.out.println(UpdateBool);
    }

    @Test
    public void testFindAll()throws Exception {
        UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");
        List <User> user = userMapper.findAll();
        System.out.println(user);
    }

    }
