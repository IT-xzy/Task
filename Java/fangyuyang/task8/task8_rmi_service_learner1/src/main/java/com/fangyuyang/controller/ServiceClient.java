package com.fangyuyang.controller;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServiceClient {
    public static void main(String[] args) {
        BeanFactory f = new ClassPathXmlApplicationContext("applicationContext.xml");
        f.getBean("rmiService");
        System.out.println("可以执行");
    }
}
