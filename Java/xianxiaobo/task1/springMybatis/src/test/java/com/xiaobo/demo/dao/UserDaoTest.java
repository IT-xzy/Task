package com.xiaobo.demo.dao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.xiaobo.demo.service.UserService;
import com.xiaobo.demo.entity.User;
import org.junit.Before;

import java.io.IOException;
import java.util.List;
public class UserDaoTest {
    private UserDao userDao;
    @Before
    public void init() throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        userDao = (UserDao) context.getBean("userDao");
    }
    @Test
    public void testGetAll() throws Exception{
        User result = userDao.getUserById(12);
        System.out.println(result);
    }
}
