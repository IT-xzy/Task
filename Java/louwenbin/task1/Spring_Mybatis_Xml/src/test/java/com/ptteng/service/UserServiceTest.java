package com.ptteng.service;

import com.ptteng.dao.mapping.UserMapper;
import com.ptteng.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceTest {
    ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
    UserMapper userMapper = (UserMapper) context.getBean("userMapper");
    User user = new User();

    @Test
    public void selectUser() {
        User user = userMapper.selectUser(1);
        System.out.println(user);
    }

    @Test
    public void insertUser() {
        user.setCreate_at(System.currentTimeMillis());
        user.setUpdate_at(System.currentTimeMillis());
        user.setName("李四");
        user.setSex("男");
        user.setQq(12354436);
        user.setType("JAVA");
        user.setAdmission("2018-01-01");
        user.setGraduate("2345");
        user.setLink("www.qq.com");
        user.setWish("养活自己");
        user.setAudit("马六");
        user.setUnderstand("CSDN");
        userMapper.insertUser(user);
        System.out.println(user);
    }

    @Test
    public void updateUser() {
        user.setId(1);
        user.setName("王五");
        System.out.println(userMapper.updateUser(user));
        System.out.println(user);
    }

    @Test
    public void deleteUser() {
        user.setId(1);
        System.out.println(userMapper.deleteUser(user.getId()));
    }
}