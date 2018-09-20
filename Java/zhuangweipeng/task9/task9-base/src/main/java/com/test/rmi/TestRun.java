package com.test.rmi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestRun {
    public static void main(String[] args){
        ApplicationContext context=new ClassPathXmlApplicationContext("spring/spring-rmi.xml");
        context.getBean("serverTest");
    }
}
