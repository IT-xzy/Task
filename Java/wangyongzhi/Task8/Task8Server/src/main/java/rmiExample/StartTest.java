package rmiExample;

import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * @Description: 原生RMI测试之启动远程服务
 */
public class StartTest {
    public static void main(String[] args){
//        System.setProperty("java.rmi.server.hostname", "39.105.149.2");
        new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("RMI服务端启动！！");
    }
}
