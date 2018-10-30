package server1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.setProperty("java.rmi.server.hostname","139.199.126.254");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("rmiServer.xml");
        System.out.println("StudentService ,发布成功！");
    }
}
