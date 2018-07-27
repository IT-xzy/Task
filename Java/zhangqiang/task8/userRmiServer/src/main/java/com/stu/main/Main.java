package com.stu.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
//        System.setProperty("java.rmi.server.hostname","47.98.50.21");
        System.setProperty("java.rmi.server.hostname","119.29.17.188");
        new ClassPathXmlApplicationContext("applicationcontext.xml");
        System.out.println("发布userService服务成功！");
    }
}
