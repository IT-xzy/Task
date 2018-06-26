package task8serverA;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        new ClassPathXmlApplicationContext("server.xml");
    }
}
