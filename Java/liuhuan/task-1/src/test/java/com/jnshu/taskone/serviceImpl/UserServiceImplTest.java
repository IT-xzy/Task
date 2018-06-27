package com.jnshu.taskone.serviceImpl;

import com.jnshu.taskone.model.User;
import com.jnshu.taskone.service.UserService;
import com.jnshu.taskone.tools.TimeTransition;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class UserServiceImplTest {
    private static ApplicationContext applicationContext;
    private static UserService userService;
    @Before
    public void tests(){
        /* 创建Spring容器 */
        applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        /* 从spring容器中获取UserDao这个bean */
        userService = (UserServiceImpl) applicationContext.getBean("userServiceImpl");
    }

    @Test
    public void findUserAll() {
        try {
            List<User> users = userService.findUserAll();
            for (int i = 0; i < users.size(); i++) {
                System.out.println(users.get(i).toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void findUserMore() {
        try {
            User user = new User();
            user.setProfession("web");
            System.out.println(userService.findUserAll());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void insertUser(){
        User user = new User();
        user.setUsername("王五");
        user.setQq("1756513254");
        user.setProfession("UI");
        user.setJoin_date(TimeTransition.dateTolong(new Date()));
        user.setSchool("武汉大学");
        user.setOnline_id("3879");
        user.setDaily_url("www.google.com");
        user.setCounselor("加油");
        user.setCreate_time();
        try {
            System.out.println("插入id为: " + userService.insertUser(user));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteUser(){
        try {
            System.out.println("删除状态为: " + userService.deleteUser(34));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void updateUser(){
        User user = new User();
        user.setUsername("王五");
        user.setQq("1756513254");
        user.setProfession("UI");
        user.setJoin_date(TimeTransition.dateTolong(new Date()));
        user.setId(33);
        try {
            System.out.println("更新状态为:" + userService.updateUser(user));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}