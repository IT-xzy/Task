package com.ptteng.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
        context.getBean("myRMIServer2-1");
        context.getBean("myRMIServer2-2");
        context.getBean("myRMIServer2-3");
        context.getBean("myRMIServer2-4");
        System.out.println("启动服务端");
    }
}
