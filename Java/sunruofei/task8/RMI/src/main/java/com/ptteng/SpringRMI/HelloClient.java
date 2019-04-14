package com.ptteng.SpringRMI;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName HelloClient
 * @Description TODO
 * @Author 孙若飞
 * @Date 2019/3/19  23:49
 * @Version 1.0
 **/
public class HelloClient {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationClient.xml");
        HelloWorld helloWord = (HelloWorld)applicationContext.getBean("HelloWorld");
        System.out.println(helloWord.helloWorld());
        System.out.println(helloWord.sayHelloToSomeBody("sunruofei"));

    }
}
