
/*
 * @ClassName:TestRedis
 * @Description:TODO
 * @Author qiao
 * @Date 2018/8/16 20:01
 **/

import com.model.People;
import com.service.UserService;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestRedis {
    private static Logger logger = Logger.getLogger("TestRedis.class");
    @Autowired
    private RedisTemplate redisTemplate;
    People people = new People();
    @Autowired
    private UserService userService;

    @Test
    public void test() {
        logger.info("21111111111111111");

        String key = "25";
        people.setName("肥宅快乐水");
        redisTemplate.opsForValue().set(key, people, 300000, TimeUnit.SECONDS);
        redisTemplate.opsForValue().set(key, people, 300000, TimeUnit.SECONDS);
        System.out.println("value：" + redisTemplate.opsForValue().get(key));
    }

//    @Test
//    public void test1() {
//        Jedis jedis = new Jedis("127.0.0.1",6397);
//        jedis.set();
//
//    }

    @Test
    public void test1() {
        People people = userService.selectById(1);
        System.out.println(people.toString());
    }

}
