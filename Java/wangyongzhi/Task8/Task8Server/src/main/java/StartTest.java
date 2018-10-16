import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * @Description: spring的RMI功能：启动服务端
 */
public class StartTest {
    public static void main(String[] args){
        System.setProperty("java.rmi.server.hostname", "39.105.149.2");
        new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("RMI服务端启动！！");
    }
}
