package com.xiaobo.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args){
        System.setProperty("java.rmi.server.hostname","182.61.19.92");
        System.out.println("server已启动");
        new ClassPathXmlApplicationContext("spring/applicationContext.xml");
    }
}
