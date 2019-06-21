package com.jnshu.tool.redis;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author pipiretrak
 * @date 2019/5/14 - 17:01
 */
@Component
public class RedisImp implements Redis{
    private static Logger logger = Logger.getLogger(RedisImp.class);

    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public boolean add(Object key, Object value) {
        if(redisTemplate==null){
            logger.info("redisTemplate 实例化失败");
            return false;
        }else{
            redisTemplate.opsForValue().set (key,value );
            return true;
        }
    }

    @Override
    public boolean addObj(Object objectKey, Object key, Object object) {
        if(redisTemplate==null){
            logger.info("redisTemplate 实例化失败");
            return false;
        }else{
            //opsForHash()操作hash
            redisTemplate.opsForHash().put(objectKey,key,object);
            return true;
        }

    }

    @Override
    public boolean add(Object key, Object value, long time) {
        if(redisTemplate==null){
            logger.info("redisTemplate 实例化失败");
            return false;
        }else{if (time>0){
            redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
        }else{
            add(key, value);
        }
        return true;
        }
    }

    @Override
    public void addHashMap(String hashMap, String key, Object value) {
        redisTemplate.opsForHash ().put (hashMap, key, value);
    }

    @Override
    public void delete(Object key) {
        redisTemplate.delete (key);
    }

    @Override
    public void deletObj(Object objecyKey, Object key) {

    }

    @Override
    public void update(Object key, String value) {

    }

    @Override
    public void updateObj(Object objectKey, Object key, Object object) {

    }

    @Override
    public Object get(Object key) {
        Object value =  redisTemplate.opsForValue().get(key);
        return value;
    }

    @Override
    public Object getObj(Object hash, Object hashKey) {
        return redisTemplate.opsForHash ().get (hash, hashKey);
    }

    @Override
    public Object getHashMap(String hashMap, String key) {
        return redisTemplate.opsForHash().get(hashMap,key);
    }
}
