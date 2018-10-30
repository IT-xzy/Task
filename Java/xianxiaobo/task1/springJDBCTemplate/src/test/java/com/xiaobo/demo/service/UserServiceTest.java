package com.xiaobo.demo.service;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.xiaobo.demo.service.UserService;
import com.xiaobo.demo.dto.User;
import org.junit.Before;

import java.io.IOException;
import java.util.List;


public class UserServiceTest {
    private UserService userService;
    @Before
    public void init() throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("MeTA_INF/applicationContext.xml");
        userService = (UserService) context.getBean("userService");
    }

    @Test
    public void testGetAll() throws Exception{
        List<User> result = userService.getAll();
        System.out.println(result);
    }
    @Test
    public void testGetUserById() throws Exception{
        Integer id = 3;
        User user = userService.getUserById(id);
        System.out.println(user);
    }
    @Test
    public void testDeleteUser() throws Exception{
        Integer id = 22;
        Boolean result = userService.deleteUser(id);
        System.out.println(result);
    }
    @Test
    public void testAddUser() throws Exception{
        User user = new User();
        user.setName("王二");
        user.setHope("混吃等死");
        Integer result = userService.addUser(user);
        System.out.println(result);
    }
    @Test
    public void testUpdateUser() throws Exception{
        User user = new User();
        user.setId(3);
        user.setName("李五");
        user.setHope("java工程师");
        Boolean result = userService.updateUser(user);
        System.out.println(result);
    }

}
