package com.token.service;

import com.token.model.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserInfoServiceTest {
    private final Logger logger = LoggerFactory.getLogger(UserInfoServiceTest.class);

    @Autowired
    private UserInfoService userInfoService;

    @Test
    public void add() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("zhangsan");
        userInfo.setPassword("zhangsan");
        userInfo.setCreate_at(System.currentTimeMillis());
        userInfo.setUpdate_at(System.currentTimeMillis());
        userInfoService.add(userInfo);
        logger.info("user_info====={}", userInfo.toString());
    }

    @Test
    public void test() {
        UserInfo user = userInfoService.getByName("ni");
        System.out.println(user);
        if (user != null) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }


}