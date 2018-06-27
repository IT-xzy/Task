package action;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RmiServerAction {
    public static void main(String[] args) {
        System.setProperty("java.rmi.server.hostname" , "111.231.109.215" );
        new ClassPathXmlApplicationContext("spring-mybatis.xml");
        System.out.println(">>启动RMI服务端");
    }
}
