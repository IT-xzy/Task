import com.zyq.util.RedisUtil;
import com.zyq.util.TelBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

public class SpringmvcRedisTest {
    private static ApplicationContext applicationContext;

    static{
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void testApplicationContext(){
        System.out.println("11111111111111111"+applicationContext);
    }
    @Test
    public void testRedisConnection(){
        RedisTemplate redisTemplate = (RedisTemplate)applicationContext.getBean("redisTemplate");
        redisTemplate.opsForValue().set("ccc","aaa");
        String string = (String) redisTemplate.opsForValue().get("ccc");
        RedisUtil redisUtil=(RedisUtil) applicationContext.getBean("redisUtil");
        System.out.println(redisUtil.get("ExcellentStudent"));
        System.out.println(string);
    }

    @Test
    public void testTelBean(){
        TelBean telBean = (TelBean) applicationContext.getBean("telBean");
        System.out.println(telBean.getAppId());
    }
}

