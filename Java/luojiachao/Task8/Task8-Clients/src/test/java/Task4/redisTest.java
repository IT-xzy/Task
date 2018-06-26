package Task4;

import Task4.cache.RedisCache;
import Task4.pojo.User;
import Task4.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class redisTest {

    @Autowired
    RedisCache redisUnit;

    @Autowired
    UserService userService;


//    private static Jedis jedis;
//
//    static {
//        jedis=new Jedis("127.0.0.1",6379);
//    }
    @Test

    public void test() {
        User user=userService.findById(2);

        User user1=(User)redisUnit.get("user1"+user.getId());
        System.out.println("key为user1的属性为"+user1);
        System.out.println("过期时间为"+redisUnit.getExpire("user1"+user.getId()));
    }
//    @Test
//    public void qidong(){
//        System.out.println(jedis.ping());
//    }

}
