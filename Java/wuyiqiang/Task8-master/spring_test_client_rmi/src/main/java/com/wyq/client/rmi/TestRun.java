package com.wyq.client.rmi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestRun {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:SpringApplicationContext.xml");
        ServerRmiI rmiI = (ServerRmiI) context.getBean("clentrmi");
        System.out.println(rmiI.sayHi("rmi"));
    }
}
