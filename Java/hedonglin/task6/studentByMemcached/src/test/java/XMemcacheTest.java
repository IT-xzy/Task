import com.student.dao.StudentDao;
import com.student.model.Student;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.TimeoutException;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class XMemcacheTest  {
    private ApplicationContext applicationContext;
    @Resource
    private StudentDao studentDao;

    @Resource
    private MemcachedClient memcachedClient;

    @Before
    public void init() {
//        applicationContext = new ClassPathXmlApplicationContext("memcache-spring.xml");
//        memcachedClient = (MemcachedClient) applicationContext.getBean("memcachedClient");

    }

    @Test
    public void test() {
        List<Student> studentList = studentDao.getAll();
        try {
            memcachedClient.set("studentList", 36000, studentList);
            System.out.println(memcachedClient.get("studentList"));
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (MemcachedException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void test1() {

        try {
            System.out.println(memcachedClient.get("studentList"));
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (MemcachedException e) {
            e.printStackTrace();
        }
    }
}
