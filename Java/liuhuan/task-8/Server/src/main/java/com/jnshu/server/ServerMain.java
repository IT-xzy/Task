package com.jnshu.server;

import com.jnshu.model.StudentCustom;
import com.jnshu.service.ServiceDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: SSM_WEB_SERVER
 * @description: 启动服务
 * @author: Mr.xweiba
 * @create: 2018-06-08 12:00
 **/

public class ServerMain {

    public static void main(String[] args) throws Exception {
        // System.setProperty("java.rmi.server.hostname", "192.168.0.115");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/applicationContext-*.xml");
        // System.out.println("Server已启动, 绑定ip为: " + java.net.InetAddress.getLocalHost().getHostAddress());
        System.out.println("Server已启动" );
    }
}
