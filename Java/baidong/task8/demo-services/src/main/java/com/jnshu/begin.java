package com.jnshu;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class  begin {
    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        System.out.println("ready.....");
    }
}

