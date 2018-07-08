package com.rmi.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String[] args) {
//        System.setProperty("java.rmi.server.hostname" , "117.48.215.129" );
        System.setProperty("java.rmi.server.hostname" , "111.230.70.237" );
        ApplicationContext context = new ClassPathXmlApplicationContext("applecationContext.xml");
    }
}
