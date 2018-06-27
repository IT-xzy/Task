package com.task;

import com.task.service.HelloWorldService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RMIClient {
    public static void main(String[] args){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
       HelloWorldService helloWord = (HelloWorldService) ctx.getBean("rmiDemo");
        System.out.println(helloWord.getMsg());
    }
}
