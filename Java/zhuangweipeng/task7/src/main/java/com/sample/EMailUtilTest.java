package com.sample;


import com.utils.EMailUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;


public class EMailUtilTest {
    private static ApplicationContext applicationContext =
            new ClassPathXmlApplicationContext("spring-account.xml");
    @Test
    public void sample() throws Exception {
        applicationContext.getBean("eMailUtil");
        //EMailUtil
        EMailUtil.sample("940311670@qq.com","1020");
    }
}