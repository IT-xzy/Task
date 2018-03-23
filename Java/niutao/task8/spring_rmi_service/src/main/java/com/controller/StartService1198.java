package com.controller;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartService1198 {

    public static void main(String[] args){
        System.setProperty("java.rmi.server.hostname","127.0.0.1");
        new ClassPathXmlApplicationContext("applicationContext1.xml");
        System.out.println("Server1198启动...");
    }
}
