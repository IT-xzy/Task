package com.ptteng.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

/**
 * @ClassName RedisImpl
 * @Description TODO
 * @Author 孙若飞
 * @Date 2019/2/27  17:14
 * @Version 1.0
 **/
@Service("Redis")
public class RedisImpl implements Cached {

    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public Boolean set(String key, Object value) {


        System.out.println(redisTemplate+"================]");
        redisTemplate.opsForValue().set(key, value);
        if (redisTemplate.opsForValue().get(key) != null) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean delete(String key) {
        redisTemplate.delete(key);
        if (redisTemplate.opsForValue().get(key) == null) {
            return true;
        }
        return false;
    }

    @Override
    public Object get(String key) {
        System.out.println("look========"+redisTemplate);
        System.out.println("key-================"+key);
        System.out.println("==========test======"+redisTemplate.opsForValue().get(key));
        return redisTemplate.opsForValue().get(key);
    }



}

