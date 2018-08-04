package com;


import com.API.message.SDKTestSendTemplateSMS;
import com.API.mail.SendCommonPostMail;
import com.Tool.MemcachedUtils;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;


public class test {
    private static Logger logger = Logger.getLogger(Test.class);
    MemcachedUtils memcachedUtils;

    @Test
    public void testMemcached(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContextMemcached.xml");
        memcachedUtils= (MemcachedUtils) applicationContext.getBean("memCachedUtil");
        String userMail="11918779@qq.com";
        memcachedUtils.set(userMail,userMail);
        String obj= (String) memcachedUtils.get(userMail);
        logger.info(obj.toString());

    }


}