package utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 自定义Redis工具类
 */
@Component
public class RedisCacheManager {
    private static final long TIME_OUT = 60*60*1000; //单位毫秒,缓存有效期
    private static final RedisTemplate redisTemplate;
    static {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-redis.xml");
        redisTemplate = (RedisTemplate) context.getBean("redisTemplate");
    }

    /**
     * redis添加缓存
     * @param key 键
     * @param value 值
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void set(String key,Object value){
        redisTemplate.opsForValue().set(key,value,TIME_OUT,TimeUnit.MILLISECONDS);
    }
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void set(Map<String,Object> map){
        redisTemplate.opsForValue().multiSet(map);
    }

    /**
     * redis获取缓存
     * @param key 键
     */
    public Object get(String key){
        return redisTemplate.opsForValue().get(key);
    }
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public List<Object> get(Collection<String> keys){
        return redisTemplate.opsForValue().multiGet(keys);
    }
    /**
     * redis重置缓存
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void replace(String key,Object value){
        redisTemplate.opsForValue().getAndSet(key,value); //替换当前value值，并返回旧的value值
    }

    /**
     * redis删除缓存
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void delete(String key){
        redisTemplate.delete(key);
    }
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void delete(Collection<String> keys){
        redisTemplate.delete(keys);
    }
}
