package com.interceptor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Repository
public class RedisTool {

    private static RedisTemplate redisTemplate;
    static {
        ApplicationContext ap=new ClassPathXmlApplicationContext("spring-redis.xml");
        redisTemplate= (RedisTemplate) ap.getBean("redisTemplate");
    }

    //普通缓存获取
    public static Object rdGet(String key){
        return redisTemplate.opsForValue().get(key);
    }

    //普通缓存添加
    public static void rdSet(String key,Object value,long time){
        redisTemplate.opsForValue().set(key,value,time,TimeUnit.SECONDS);
    }
    //普通缓存删除
    public static void rdDel(String key){
          redisTemplate.delete(key);
    }
    //获得key
    public static boolean rdGetKey(String key){
        try {
            return redisTemplate.hasKey(key);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }




}
