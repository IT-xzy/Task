package com.ptteng;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartRMIServer {

    public static void main(String[] args) {
        System.setProperty("java.rmi.server.hostname", "47.96.102.53");
        new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("RMI服务端启动！！！");
    }
}
