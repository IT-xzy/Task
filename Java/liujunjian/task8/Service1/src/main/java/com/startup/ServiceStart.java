package com.startup;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ServiceStart {
    public static void main(String[] args) throws Exception {
        new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        System.out.println("rmi已启动");
        //退出程序，控制台输入exit结束service
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            if (reader.readLine().equals("exit")) {
                System.exit(0);
            }
        }
    }
}
