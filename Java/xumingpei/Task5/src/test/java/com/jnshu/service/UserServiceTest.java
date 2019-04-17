package com.jnshu.service;

import com.jnshu.pojo.User;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author pipiretrak
 * @date 2019/4/14 - 9:36
 */
@ContextConfiguration(locations = "classpath:SpringMybatis.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {
    private static Logger logger = Logger.getLogger(StudentServiceTest.class);

    @Autowired
    UserService userService;

    @Test
    public void insert(){
        User user = new User();
        user.setName("小徐");
        user.setPassword("123456");
        userService.insert(user);


    }

}
