import com.suger.util.RedisUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * @author suger
 * @date 2018/12/6 17:28
 * 测试 Redis 整合
 */
public class TestRedis {


    public static void main(String[] args) throws Exception {
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:spring/spring-mybatis.xml");

        RedisUtils redisUtil = (RedisUtils) context.getBean("redisUtils");

        //=====================testString======================
        redisUtil.set("name", "哈哈哈哈");
        System.out.println(redisUtil.get("name"));
        redisUtil.delete("name");
        System.out.println(redisUtil.get("name"));

        //=====================testNumber======================
        long incr = redisUtil.incr("number", 1);
        System.out.println(incr);
        incr =redisUtil.incr("number", 1);
        System.out.println(incr);

        //=====================testMap======================
        Map<String,Object> map=new HashMap<>();
        map.put("name","哈哈哈哈");
        map.put("pwd", "password");
        redisUtil.hmset("user", map);
        System.out.println(redisUtil.hget("user","name"));
    }


}

