package com.jnshu.tool.redis;

import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author pipiretrak
 * @date 2019/5/14 - 16:48
 */
public interface Redis {
    public void setRedisTemplate(RedisTemplate redisTemplate);
    //增
    boolean add(Object key, Object value);
    boolean addObj(Object hash, Object hashKey, Object value);
    boolean add(Object key, Object value, long time);
    void addHashMap(String hashMap, String key, Object value);
    //删
    void delete(Object key);
    void deletObj(Object objecyKey, Object key);
    //改
    void update(Object key, String value);
    void updateObj(Object objectKey, Object key, Object object);
    //查
    Object get(Object key);
    Object getObj(Object hash, Object hashKey);
    Object getHashMap(String hashMap, String key);
}
