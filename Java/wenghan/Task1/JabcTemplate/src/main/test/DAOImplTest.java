import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class DAOImplTest {
    JdbcTemplate jdbcTemplate=null;
    ApplicationContext context=null;
    //通过配置文件获得配置好数据源的JdbcTemplate对象
    @Before
    public void BeforeTest(){
        context=new ClassPathXmlApplicationContext("bean.xml");
    }
    //通过有参加构造函数将配置好数据源的JdbcTemplate对象传入DAO实现类对象中
    @Test
    public void addStudent() {
       for(int i=0;i<1000;i++) {
           jdbcTemplate=(JdbcTemplate) context.getBean("jdbcTemplate");
           new DAOImpl(jdbcTemplate);
       }
    }
    @After
    public void AfterTest(){
        System.out.println("After");
    }
}