package com.ssm.utils;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;

public class TestTest {

    @Test
    public void test1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        SmsUtil smsUtil = (SmsUtil) applicationContext.getBean("smsUtil");

        System.out.println(smsUtil.getAk());
        System.out.println(smsUtil.getSk());
    }
}