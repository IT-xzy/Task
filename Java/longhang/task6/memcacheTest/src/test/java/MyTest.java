import com.longhang.model.Student;
import com.longhang.stuService.StuService;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeoutException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MyTest {
    @Autowired
    private StuService stu;
    @Autowired
    private MemcachedClient memcachedClient;

    @Test
    public void s() throws InterruptedException, MemcachedException, TimeoutException {

        if (memcachedClient.get("students") == null) {
            List<Student> students = stu.getGetAll();
            memcachedClient.set("students", 10 * 60 * 1000, students);

            System.out.println("123:" + memcachedClient.get("students"));
            List<Student> students1 = memcachedClient.get("students");
            Iterator<Student> s = students1.iterator();
            while (s.hasNext()) {

                System.out.println("这些人是：" + s.next().toString());
            }
        }
    }
}

