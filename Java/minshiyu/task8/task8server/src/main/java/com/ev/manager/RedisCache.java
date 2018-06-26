package com.ev.manager;

import com.ev.entity.GoodOne;
import com.ev.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisCache {

    private StringRedisTemplate redisTemplate;

    @Autowired(required = false)
    public void setStringRedisTemplate(StringRedisTemplate stringRedisTemplate) {
        stringRedisTemplate.setHashValueSerializer(new Jackson2JsonRedisSerializer<>(GoodOne.class));
        this.redisTemplate = stringRedisTemplate;
    }
    public void setString(String key, String value, Long expMinutes) throws Exception{
        redisTemplate.opsForValue().set(key, value, expMinutes, TimeUnit.MINUTES);
    }

    public Object getString(String key) throws Exception{
        return redisTemplate.opsForValue().get(key);
    }

    public void setHash(String hash, Object key, Object object) throws Exception{
        redisTemplate.opsForHash().put(hash, key.toString(), object);
    }

    public Object getHash(String hash, Object key) throws Exception{
        return redisTemplate.opsForHash().get(hash, key.toString());
    }

    public void flushAll() throws Exception{
        redisTemplate.getConnectionFactory().getConnection().flushAll();
    }

}


