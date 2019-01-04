package task7.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = "classpath:spring-servlet.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class RedisUtilTest {
    @Autowired
    private RedisUtil redisUtil;
    @Test
    public void expire() {

    }

    @Test
    public void getExpire() {
    }

    @Test
    public void get() {
        String s =(String) redisUtil.get("1015320765@qq.com");
        System.out.println(s);

    }

    @Test
    public void set() {
        boolean b =redisUtil.set("验证码","123654");
        System.out.println(b);

    }

    @Test
    public void set1() {
        boolean b =redisUtil.set("验证码","123654",10);
        System.out.println(b);
    }
}