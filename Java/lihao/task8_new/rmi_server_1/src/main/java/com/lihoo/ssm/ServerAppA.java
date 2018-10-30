package com.lihoo.ssm;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class ServerAppA
{
    public static void main( String[] args )
    {
        System.out.println("RMI-1-服务端开启中...");
        AbstractApplicationContext aac =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("*****准备使用rmi客户端-1077-*****");
    }
}
