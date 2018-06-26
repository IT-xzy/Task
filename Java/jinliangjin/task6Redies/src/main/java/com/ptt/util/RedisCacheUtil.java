package com.ptt.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @ClassName: RedisCacheUtil
 * @Description: 操作Redis缓存的工具类，key：表名；id：唯一字段名；Object：redis缓存的value值。
 * @Author: Jin
 * @CreateDate: 2018/6/7 22:35
 * @Version: 1.0
 */
@Component
public class RedisCacheUtil {
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * @Description: 新增缓存
     * @return: void
     * @Date: 2018/6/7 23:24
     */
    public void add(String key, String name, Object value) {
        if (null == key || "".equals(key))
            return;
        redisTemplate.opsForHash().put(key, name, value);
    }

    /**
     * @Description: 查询缓存值
     * @return: java.lang.Object
     * @Date: 2018/6/7 23:25
     */
    public Object getValue(String key, String name) {
        if (null == key || "".equals(key))
            return null;
        return redisTemplate.opsForHash().get(key, name);
    }

    /**
     * @Description: 判断缓存是否存在
     * @return: boolean
     * @Date: 2018/6/7 23:25
     */
    public boolean exist(String key, String name) {
        if (null == key || "".equals(key))
            return false;
        return redisTemplate.opsForHash().hasKey(key, name);
    }

    /**
     * @Description: 查询缓存了某张表的数据数
     * @return: long
     * @Date: 2018/6/7 23:26
     */
    public long getSize(String key) {
        if (null == key || "".equals(key))
            return 0L;
        return redisTemplate.opsForHash().size(key);
    }

    /**
     * @Description: 删除缓存
     * @return: void
     * @Date: 2018/6/7 23:27
     */
    public void delete(String key, String name) {
        if (null == key || "".equals(key))
            return;
        redisTemplate.opsForHash().delete(key, name);
    }
}
