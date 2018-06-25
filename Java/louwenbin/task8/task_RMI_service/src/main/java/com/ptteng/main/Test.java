package com.ptteng.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
        context.getBean("myRMIServer1-1");
        context.getBean("myRMIServer1-2");
        context.getBean("myRMIServer1-3");
        context.getBean("myRMIServer1-4");
        System.out.println("启动服务端");
    }
}
