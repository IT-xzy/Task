package com.task;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartRMIServer {
    public static void main(String[] args) {
        System.setProperty("java.rmi.server.hostname", "116.62.18.233");
        new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("RMI服务端启动！！！");
    }
}
