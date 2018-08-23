package com.task8.rmi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Create by SongWu on 2018/8/14
 */
public class RmiTest {
    public static void main(String[] args) {
//        System.setProperty("java.rmi.server.hostname","47.106.92.44");
        ApplicationContext context= new ClassPathXmlApplicationContext("spring/applicationContext-.xml");
//        context.getBean("myRMIServer1");
//        context.getBean("myRMIServer2");
//        context.getBean("myRMIServer3");

        System.out.println("服务已启动a");
    }


}
