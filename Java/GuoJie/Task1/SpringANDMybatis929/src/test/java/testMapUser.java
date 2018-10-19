import com.jnshu.Spring.SpringMybatis.MapUserDao;
import com.jnshu.Spring.User;
import org.junit.Before;
import org.junit.Test;
        import org.springframework.context.ApplicationContext;
        import org.springframework.context.support.ClassPathXmlApplicationContext;

/*创建于2018-10-1日完成与10-2日*/
        public class testMapUser {
    private ApplicationContext apx;
    @Before
    public void setUp() throws Exception{
        apx=new ClassPathXmlApplicationContext("mySpringNoAnnotation.xml");
    }
    @Test
    public void testSpringMyabtis(){
        MapUserDao mapUserDao=(MapUserDao)apx.getBean("mapUserDao");
        User user=mapUserDao.findById(3);
        System.out.println(user);
    }
}
