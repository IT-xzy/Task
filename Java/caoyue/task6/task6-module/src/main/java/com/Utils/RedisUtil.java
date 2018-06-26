package com.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @author: 曹樾
 * @program: task6-module
 * @description: Redis工具类
 * @create: 2018/5/23 上午11:17
 */

public class RedisUtil {
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
    
    public RedisTemplate<String, Object> getRedisTemplate() {
        return redisTemplate;
    }
    
    /**
     * 向缓存里面添加值
     * @param key
     * @param field
     * @param obj
     */
    public void hashSet(String key, String field, Object obj) {
        if(key == null || "".equals(key)){
            return ;
        }
        redisTemplate.opsForHash().put(key, field, obj);
        redisTemplate.expire(key,10, TimeUnit.DAYS);
    }
    
    /**
     * 从缓存中取值
     * @param key
     * @param field
     * @return
     */
    public Object hashGet(String key, String field) {
        if(key == null || "".equals(key)){
            return null;
        }
        return  redisTemplate.opsForHash().get(key, field);
    }
    
    /**
     * 判断数据是否存在
     * @param key
     * @param field
     * @return
     */
    public boolean hasKey(String key,String field) {
        if(key == null || "".equals(key)){
            return false;
        }
        return redisTemplate.opsForHash().hasKey(key, field);
    }
    
    /**
     * 判断缓存长度
     * @param key
     * @return
     */
    public long hashSize(String key) {
        if(key == null || "".equals(key)){
            return 0L;
        }
        return redisTemplate.opsForHash().size(key);
    }
    
    /**
     * 删除hash值
     * @param key
     * @param field
     */
    public void hashDel(String key, String field) {
        if(key == null || "".equals(key)){
            return;
        }
        redisTemplate.opsForHash().delete(key, field);
    }
}
