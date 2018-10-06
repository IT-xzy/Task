import com.jnshu.Spring.SpringMybatisAnnotation.service.MyService;
import com.jnshu.Spring.SpringMybatisAnnotation.service.MyServiceImpl;
import com.jnshu.Spring.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*创建于2018-10-2日*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:SpringAnnotation.xml")
public class TestAnnotation {
    @Autowired
    MyService myService;
    @Test
    public void test1(){
        User user=myService.QueryById(1);
        System.out.println(user);
    }
}
