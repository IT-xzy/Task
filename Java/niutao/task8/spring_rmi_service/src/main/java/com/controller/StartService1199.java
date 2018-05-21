package com.controller;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartService1199 {
    public static void main(String[] args){
        System.setProperty("java.rmi.server.hostname","207.148.67.85");
        new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("Server1199启动...");
    }
}
