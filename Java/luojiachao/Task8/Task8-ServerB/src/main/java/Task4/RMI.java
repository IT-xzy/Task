package Task4;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RMI {
    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("RMI服务端B启动！！！");
    }
}