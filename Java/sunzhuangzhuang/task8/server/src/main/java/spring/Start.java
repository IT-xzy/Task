package spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Start {
    public static void main(String[] args){
        System.setProperty("java.rmi.server.hostname","106.14.220.166");
        new ClassPathXmlApplicationContext("applicationContext.xml");
         System.out.println(">>>服务端启动");
    }
}
