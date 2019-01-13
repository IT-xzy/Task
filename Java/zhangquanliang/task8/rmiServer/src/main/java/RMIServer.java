import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author suger
 * @date 2019/1/2 20:35
 */
public class RMIServer {
    public static void main(String[] args) {

        System.setProperty("java.rmi.server.hostname","172.17.13.209");

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/spring-mybatis.xml");
        System.out.println("applicationContext = " + applicationContext);
        System.out.println("服务已启动");
    }
}
