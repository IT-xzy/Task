import com.jnshu.Spring.daoSpring.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testDaoSpring {
    @Test
    public void testDaoSpring(){
        ApplicationContext apx= new  ClassPathXmlApplicationContext("mySpringNoAnnotation.xml");
        UserService userService=(UserService) apx.getBean("myServiceImpl");
        userService.add();
    }
}
