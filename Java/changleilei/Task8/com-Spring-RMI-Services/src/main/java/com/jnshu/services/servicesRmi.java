package com.jnshu.services;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class servicesRmi {
    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("spring-mybatis.xml");
    }
}
