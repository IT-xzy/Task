package com.task7.util;

import org.apache.log4j.Logger;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.io.Serializable;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Create by SongWu on 2018/7/31
 */
public class RedisUtil {
    private static Logger logger = Logger.getLogger(RedisUtil.class);

    private static RedisTemplate<Serializable, Object> redisTemplate;

    /**
     * 写入或更新缓存
     * @param key
     * @param value
     * @return
     */
    public  boolean set(final String key, Object value)
    {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate
                    .opsForValue();
            operations.set(key, value);
            result = true;
        } catch (Exception e) {
            logger.error("write redis is faill");
            e.printStackTrace();

        }
        return result;
    }


    /**
     * 写入缓存
     *  设置失效时间
     * @param key
     * @param value
     * @return
     */
    public  boolean set(final String key, Object value, Long expireTime) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate
                    .opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    /**
     * 读取缓存
     * @param key
     * @return
     */
    public  Object get(final String key)
    {
        Object result = null;
        ValueOperations<Serializable, Object> operations = redisTemplate
                .opsForValue();
        result = operations.get(key);
        return result;
    }

    /**
     * 删除对应的value
     * @param key
     */
    public  void remove(final String key)
    {
        if (exists(key)) {
            redisTemplate.delete(key);
        }
    }

    /**
     * 批量删除对应的value
     *
     * @param keys
     */
    public  void remove(final String... keys) {
        for (String key : keys) {
            remove(key);
        }
    }

    /**
     * 批量删除key
     *
     * @param pattern 正则表达式
     */
    public  void removePattern(final String pattern) {
        Set<Serializable> keys = redisTemplate.keys(pattern);
        if (keys.size() > 0)
            redisTemplate.delete(keys);
    }

    /**
     * 判断缓存中是否有对应的value
     *
     * @param key
     * @return
     */
    public  boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }

    public  void setRedisTemplate(
            RedisTemplate<Serializable, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

}
