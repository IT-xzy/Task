import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import pojo.User;

/**
 * 测试Redis存取缓存
 */
public class RedisTemplateTest {
    private ApplicationContext context =new ClassPathXmlApplicationContext("spring-redis.xml");
    private RedisTemplate redisTemplate = (RedisTemplate) context.getBean("redisTemplate");

    @Test
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void test1(){
        User user =new User();
        user.setName("li");
        user.setPassword("123");
        redisTemplate.opsForValue().set("key1","value1");
        redisTemplate.opsForValue().set("user",user);
        System.out.println(redisTemplate.opsForValue().get("user"));

        redisTemplate.opsForValue().getAndSet("key1","replaceValue");
        System.out.println(redisTemplate.opsForValue().get("key1"));
    }
}
