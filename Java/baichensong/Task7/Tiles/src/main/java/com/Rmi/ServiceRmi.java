package com.Rmi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServiceRmi {

    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext-*.xml");
        context.getBean("RmiService");
        System.out.println("--------------服务启动成功--------------");

    }

}

