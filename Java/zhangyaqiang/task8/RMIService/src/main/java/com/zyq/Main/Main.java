package com.zyq.Main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        System.setProperty("java.rmi.server.hostname","139.199.126.254");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("task7.2服务已启动,java.rmi.server.hostname:139.199.126.254");
    }
}
