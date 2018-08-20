package com.jnshu.client;


import com.jnshu.dao.IRmiServer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestRmi {
    public static void main(String[] arg) {
        System.out.println("rmi客户端开始调用");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean2.xml");
        IRmiServer rmi=(IRmiServer)ctx.getBean("testRmiService");
        rmi.test();
        System.out.println("rmi客户端调用结束");
    }

}
