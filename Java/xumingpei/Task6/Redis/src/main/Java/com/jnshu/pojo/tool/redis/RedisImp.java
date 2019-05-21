package com.jnshu.pojo.tool.redis;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

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
    public void add(Object key, Object value) {
        if(redisTemplate==null){
            logger.info("redisTemplate 实例化失败");
            return;
        }else{
            redisTemplate.opsForValue().set (key,value );
        }
    }

    @Override
    public void addObj(Object objectKey, Object key, Object object) {
        if(redisTemplate==null){
            logger.info("redisTemplate 实例化失败");
            return;
        }else{
            //opsForHash()操作hash
            redisTemplate.opsForHash().put(objectKey,key,object);
        }

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
}
