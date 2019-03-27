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
 * @date 2019/3/20 - 3:05
 */
@ContextConfiguration(locations = "classpath:SpringMybatis.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {
    private static Logger logger = Logger.getLogger(UserServiceTest.class);


    @Autowired
    UserService userService;
    User user = new User();

    @Test
    public void insert(){

        user.setName("游客1");
        user.setCreateAt(System.currentTimeMillis());
        user.setUpdateAt(System.currentTimeMillis());
        user.setCreateBy("徐铭培1");
        user.setUpdateBy("姜子牙1");
        logger.info(String.valueOf(userService.insert(user)));
    }

    @Test
    public void update(){

        user.setName("被更改的游客");
        user.setCreateAt(System.currentTimeMillis());
        user.setUpdateAt(System.currentTimeMillis());
        user.setCreateBy("技能树");
        user.setUpdateBy("122fds");
        user.setId(1);
        logger.info(String.valueOf(userService.updateByPrimaryKey(user)));
    }

    @Test
    public void selectByDynamic(){
        logger.info(String.valueOf(userService.selectByDynamic(null,null)));
    }

    @Test
    public void delete(){
        logger.info(String.valueOf(userService.deleteByPrimaryKey((long)1)));
    }
}
