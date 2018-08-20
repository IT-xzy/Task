package com.jnshu.dao;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;




public class MainServer {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("rmi服务端启动");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean1.xml");

        System.out.println("rmi服务端启动完成。。。");
    }

}
