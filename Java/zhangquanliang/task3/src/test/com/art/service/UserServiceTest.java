package com.art.service;

import com.art.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author suger
 * @date 2018/11/4 23:23
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-mybatis.xml"})

public class UserServiceTest {

    @Autowired
    UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(UserServiceTest.class);

    @Test
    public void insert() throws Exception {
        User user = new User();
        user.setUserName("新增用户");
        user.setPassword("123456");
        user.setRole("测试");
        Long time = System.currentTimeMillis();
        user.setCreateAt(time);
        user.setUpdateAt(time);
        user.setCreateBy("梵高");
        boolean t = userService.insert(user);
        logger.info("----新增----:"+t);
    }

    @Test
    public void getUser() throws Exception {
        int id = 2;
        logger.info("----查询----"+userService.getUser(id));
    }

    @Test
    public void delete() throws Exception {
        int id = 3;
        logger.info("----删除----"+userService.delete(id));
    }

    @Test
    public void update() throws Exception {
        User user = new User();
        user.setId(4);
        user.setUserName("更新用户");
        user.setPassword("123456");
        user.setRole("更新");
        Long time = System.currentTimeMillis();
        user.setUpdateAt(time);
        user.setCreateBy("梵高");
        logger.info("----更新----"+userService.update(user));
    }

}