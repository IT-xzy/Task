package com.jnshu.tools;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Redis {


//    ApplicationContext build = new ClassPathXmlApplicationContext("spring-redis.xml");
//
//    RedisTemplate redisTemplate = (RedisTemplate) build.getBean("redisTemplate");


    static RedisTemplate redisTemplate;

    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 缓存
     *
     * @param key
     * @param value
     * @param <T>
     * @return
     */
    public <T> ValueOperations<String, T> setCacheObject(String key, T value,long time) {
        ValueOperations<String, T> operations = redisTemplate.opsForValue();
        operations.set(key, value,time,TimeUnit.MILLISECONDS);
        return operations;
    }
}


