package com.iceneet.RMI;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class startRMIserver {
    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("spring/spring-dao.xml","spring/spring-redis.xml","spring/spring-rmi.xml"
);
        System.out.println("RMI服务端启动");
    }
}
