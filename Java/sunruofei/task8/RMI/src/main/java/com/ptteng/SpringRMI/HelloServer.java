package com.ptteng.SpringRMI;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName HelloServer
 * @Description TODO
 * @Author 孙若飞
 * @Date 2019/3/19  23:42
 * @Version 1.0
 **/
public class HelloServer {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationServer.xml");
        System.out.println("服务伴随着spring启动而启动");

    }
}
