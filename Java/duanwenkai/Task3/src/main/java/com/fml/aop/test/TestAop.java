package com.fml.aop.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAop {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorldImpl");

        helloWorld.printHelloWorld();
        helloWorld.doPrint();
    }
}
