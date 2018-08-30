package com.main;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class main {
        public static void main(String args[]){
            //System.setProperty("java.rmi.server.hostname","47.98.143.242");
            new ClassPathXmlApplicationContext("spring-mybatis.xml");
            System.out.println("服务端RMI 1200 启动");
        }
}
