package com.jnshu.task5.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

public class RedisClientUtil {
    /**
     * 连接池
     */
    private static JedisPool pool;

    static {
        pool = new JedisPool("localhost", 6379);

    }

    /**
     * JDk序列对象并存储List集合
     *
     * @param key
     * @param list
     */
    public static void setList(String key, List<?> list) {
        Jedis jedis = pool.getResource();
        try {
            if (list == null || list.size() == 0) {
                // 如果list为空,则设置一个空串""
                jedis.set(key.getBytes(), "".getBytes());
            } else {
                jedis.set(key.getBytes(), JDKSerializeUtil.serializeList(list));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedis.close();
        }
    }

    /**
     * JDK反序列对象并获取List集合
     *
     * @param key
     * @return
     */
    public static List<?> getList(String key) {
        Jedis jedis = pool.getResource();
        if (jedis == null || !jedis.exists(key)) {
            return null;
        }
        byte[] data = jedis.get(key.getBytes());
        jedis.close();
        return JDKSerializeUtil.unserializeList(data);
    }



}
