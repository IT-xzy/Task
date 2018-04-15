
import org.junit.Test;
        import org.junit.runner.RunWith;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.test.context.ContextConfiguration;
        import com.Student;
        import com.StudentMapper;
        import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringMybatisTest  {
    /*  private ApplicationContext applicationContext;*/
    @Autowired
    StudentMapper studentMapper;
    /*@Before
    public void setup(){
        applicationContext=new ClassPathXmlApplicationContext("beans.xml");
    }*/
    @Test
    public void testFindUserById1() throws Exception {
//        com.UserMapper userMapper = (com.UserMapper) applicationContext.getBean("userMapper");
        
        Student student = studentMapper.findUserById(1);
        System.out.println(student);
    }
}
