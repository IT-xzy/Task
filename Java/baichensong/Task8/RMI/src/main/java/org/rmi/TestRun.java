package org.rmi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class TestRun {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-S.xml");
        context.getBean("serverTest");
        System.out.println("==============服务启动成功 ==============");

    }

}