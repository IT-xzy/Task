import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试
@ContextConfiguration(locations={"classpath:applicationContext.xml"}) //加载配置文件
public class Test {
    @org.junit.Test
    public void test(){
        ClassPathXmlApplicationContext contextxt = new ClassPathXmlApplicationContext("applicationContext.xml");
        Object object = contextxt.getBean("emailRMIClient");
        System.out.println(object);
    }
}
