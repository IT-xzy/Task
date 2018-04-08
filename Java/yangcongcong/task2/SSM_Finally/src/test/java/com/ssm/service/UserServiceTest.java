package com.ssm.service;

import com.ssm.controller.UserController;
import com.ssm.dao.UserMapper;
import com.ssm.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Enzo Cotter on 18/4/3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserServiceTest {
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserMapper userMapper;
    @Test
    public void addUser() throws Exception {

        int retResult=0;
        User user = new User();
        try {
            for (int i=1;i<120;i++) {
                user.setName("张三");
                user.setNumber(123);
                user.setQq(323213);
                user.setType("后端");
                user.setUniversity("家里蹲大学");
                user.setDaily_link("www.nihao.com");
                user.setPledge("无敌");
                user.setSenior("随便");
                user.setLocality("知乎");
                user.setCreate_at(System.currentTimeMillis());
                user.setUpdate_at(System.currentTimeMillis());
                retResult=userMapper.addUser(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (retResult == 1) {
                logger.info("添加用户,ID为：{}", user.getId());
            } else {
                logger.info("添加失败");
            }
        }
    }

}