package jnshu.tool.redis;

import org.springframework.data.redis.core.RedisTemplate;

public class Redis {

    RedisTemplate redisTemplate;

    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }


    public  void setHashMap(String hashMap, String key, Object value) {

        redisTemplate.opsForHash ().put (hashMap, key, value);
    }

    public  Object getHashMap(String hashMap, String key) {
        return redisTemplate.opsForHash ().get (hashMap, key);
    }


}


