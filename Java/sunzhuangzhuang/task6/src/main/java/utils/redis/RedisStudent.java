package utils.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisStudent {
    @Autowired
    private static RedisTemplate redisTemplate;
    static {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        redisTemplate =  applicationContext.getBean(RedisTemplate.class);
    }

    //添加缓存
    public void set(Object key,Object value){
        redisTemplate.opsForValue().set(key,value);
    }

    //读取缓存
    public Object get(Object key){
        return redisTemplate.opsForValue().get(key);
    }

}
