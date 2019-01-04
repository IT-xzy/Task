package task7.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@ContextConfiguration(locations = "classpath:spring-servlet.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class DysSmsUtilTest {
    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void sendSms() {
        Boolean flag =DysSmsUtil.sendSms("13760757853");
        System.out.println(flag);
        System.out.println(redisUtil.set("code", DysSmsUtil.number, 100));
        System.out.println( redisUtil.get("code"));
    }
}