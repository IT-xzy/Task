import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestRmi {
    public static void main(String[] args) {
        //初始化工作只能运行一次;运行多次的话，会启动多个服务
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("Spring rmi 测试程序服务已启动");
    }
}
