package service;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RmiClient {
        public static void main(String[] args) throws InterruptedException {
            System.setProperty("java.rmi.server.hostname", "120.131.8.132");
            new ClassPathXmlApplicationContext("applicationContext.xml");
            System.out.print("启动服务:8080端口\n");
            Object lock = new Object();
            synchronized (lock) {
                lock.wait();
            }
        }
}
