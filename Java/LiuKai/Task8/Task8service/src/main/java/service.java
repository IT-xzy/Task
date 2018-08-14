import org.springframework.context.support.ClassPathXmlApplicationContext;


public class service {

    public static void main(String[] args) {

         System.setProperty("java.rmi.server.hostname","47.96.95.132");
        new ClassPathXmlApplicationContext("applicationContext.xml");

    }
}
