package com.jnshu.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: Tiles
 * @description:
 * @author: Mr.Lee
 * @create: 2018-07-17 10:18
 **/
@Component
public class JedisCache {

    private static final Logger LOGGER = LoggerFactory.getLogger(JedisCache.class);

    @Resource
    private RedisTemplate<String,Object>  redisTemplate;

    public void setRedisTemplate(RedisTemplate<String ,Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 设置string缓存
     * @param key
     * @param value
     * @return
     */
    public boolean set(String key, Object value){
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e){
            LOGGER.info("设置Jedis缓存失败", e);
            return false;
        }
    }

    /**
     * 设置list缓存
     * @param key
     * @param value
     * @return
     */
    public boolean setStudent(String key, Object value){
        try {
            redisTemplate.opsForList().rightPushAll(key, value);
            return true;
        } catch (Exception e){
            LOGGER.error("设置Student缓存失败", e);
            return false;
        }
    }


    /**
     * 获取list缓存
     * @param key
     * @return
     */
    public List getStudent(String key){
        try {
            return redisTemplate.opsForList().range(key, 0 ,-1);
        } catch (Exception e){
            LOGGER.error("获取Student缓存失败", e);
            return null;
        }
    }


    /**
     * 根据key获取缓存
     * @param key
     * @return
     */
    public Object get(String key){
        try {
            return redisTemplate.opsForValue().get(key);
        } catch (Exception e){
            LOGGER.error("读取Jedis缓存失败", e);
            return null;
        }
    }

    /**
     * 根据key删除缓存
     * @param key
     * @return
     */
    public boolean delete(String key){
        try {
            redisTemplate.opsForValue().getOperations().delete(key);
            return true;
        } catch (Exception e){
            LOGGER.error("删除Jedis缓存失败", e);
            return false;
        }
    }
}
