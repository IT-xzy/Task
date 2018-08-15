package utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class Redis {
    @Autowired
    RedisTemplate redisTemplate;
    private static final long OUTTIMEE = 30*60*1000;

    //添加缓存
    public void set(Object key,Object value){
        redisTemplate.opsForValue().set(key,value,OUTTIMEE,TimeUnit.MILLISECONDS);
    }

    //读取缓存
    public Object get(Object key){
        return redisTemplate.opsForValue().get(key);
    }

    //删除缓存
    public void delete(Object key){
        redisTemplate.delete(key);
    }
}


