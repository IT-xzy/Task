package hzw.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RmiService {
    public static void main(String args[]){
        //System.setProperty("java.rmi.server.hostname","47.98.143.242");
        new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("服务端RMI8888启动");
    }
}
