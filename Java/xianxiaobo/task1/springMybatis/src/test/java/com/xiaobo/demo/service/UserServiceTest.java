package com.xiaobo.demo.service;
import com.xiaobo.demo.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.apache.log4j.Logger;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class UserServiceTest {
    private static Logger log = Logger.getLogger(UserServiceTest.class);
    @Autowired
    private UserService userService;
    @Test
    public void testGetAll(){
        List<User> result = userService.getAll();
        log.info(result);
    }
    @Test
    public void testGetUserById(){
        Integer id = 1003;
        User result = userService.getUserById(id);
        log.info(result);
    }
    @Test
    public void testDeleteUser() throws Exception{
        Integer id = 28;
        Boolean result = userService.deleteUser(id);
        log.info(result);
    }
    @Test
    public void testAddUser() throws Exception{

        User user = new User();
        user.setName("王二");
        user.setHope("混吃等死");
        Integer result = userService.addUser(user);
        log.info(result);
        log.info(user.getId());
    }
    @Test
    public void testUpdateUser() throws Exception{
        User user = new User();
        user.setId(34);
        user.setName("李八");
        user.setHope("java工程师");
        Boolean result = userService.updateUser(user);
        log.info(result);
    }
}
