package com.ptteng.redis;

import com.ptteng.util.SerializableUtilForRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.io.IOException;

@Component
public class Redis {
    @Autowired
    JedisPool jedisPool;
    @Autowired
    SerializableUtilForRedis serializableUtilForRedis;
    //查
    public byte[] get(String key){
        Jedis jedis = jedisPool.getResource();
        byte[] value = null;
        if (jedis.exists(key.getBytes())){
            value = jedis.get(key.getBytes());
        }else {
            value = null;
        }
        jedis.close();
        return value;
    }
    //存
    public void save(byte[] key,byte[] value){
        Jedis jedis = jedisPool.getResource();
        jedis.set(key, value);
        jedis.close();
    }
}
