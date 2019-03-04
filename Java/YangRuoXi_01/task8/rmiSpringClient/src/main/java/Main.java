import com.jnshu.springrmi.service.Message;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:context.xml");
        System.out.println("初始化服务端");

        Message client = (Message) ctx.getBean("messageService");

        String tmp = client.hello("spring rmi ");
        System.out.println("返回结果 " + tmp);

    }
}
