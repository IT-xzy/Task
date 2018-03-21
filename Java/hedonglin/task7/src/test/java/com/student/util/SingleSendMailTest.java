package com.student.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class SingleSendMailTest {
    @Resource
    private SingleSendMail singleSendMail;

    @Test
    public void sample() {
        String emailCode =singleSendMail.getEmailCode();
        singleSendMail.sample("781190082@qq.com",emailCode,"常雷雷");
    }

    @Test
    public void getEmailCode() {
    }
}