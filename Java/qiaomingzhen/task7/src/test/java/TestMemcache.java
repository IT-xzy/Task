import com.model.Profession;
import com.service.ProfService;
import com.service.UserService;
import com.whalin.MemCached.MemCachedClient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.support.DaoSupport;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLOutput;
import java.util.Date;
import java.util.List;
import java.util.Random;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestMemcache {
    @Autowired
    MemCachedClient memCachedClient;
    @Autowired
    private ProfService profService;
    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

//    @Before
//    public void beforeTest() {
//
//        ApplicationContext atx = new ClassPathXmlApplicationContext("applicationContext.xml");
//        memCachedClient = (MemCachedClient) atx.getBean("memcachedClient");
//    }


    @Test
    public void TestMem() {

        long time =(long) (Math.random()*5000);
        System.out.println(time);
        System.out.println(System.currentTimeMillis()+time);
//        memCachedClient.set("name4", "qiao", new Date(time+1000));
        memCachedClient.set("name3", "qiao", new Date((long) (Math.random()*5000)));
//        memCachedClient.flushAll();
        System.out.println(memCachedClient.get("name4"));
        System.out.println(memCachedClient.get("name3"));
//        userService.selectById(1);
    }


    @Test
    public void TestMem1() {
        List<Profession> list = profService.group();
        memCachedClient.set("profession", list);
        List<Profession> list1 = (List<Profession>) memCachedClient.get("profession");
        for (Profession p : list1) {
            System.out.println(p.toString());
        }
    }

    @Test
    public void test2() {

        int num = (int) (Math.random() * 5 + 1);

        System.out.println("num:" + num);
    }
    @Test
    public void test3(){
        memCachedClient.set("17635265173","951128");
        System.out.println(memCachedClient.get("17635265173"));
    }
}


