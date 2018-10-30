package cn.wyq.util;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RmiServiceTest {
    public static void main(String[] args) {
        System.setProperty("java.rmi.server.hostname","47.104.225.105");
        new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("rmi service服务启动成功，ip：47.104.225.105");
    }
}
