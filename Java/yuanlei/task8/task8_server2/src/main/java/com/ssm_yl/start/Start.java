package com.ssm_yl.start;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Start {
    public static void main (String[] args){
        new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        System.out.printf("task8服务器2启动");
    }
}
