package jnshu.cache;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component("Redis")
public class RedisImpl implements Cached {

    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public Boolean set(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
//        设置的的方法返回值为空 ，通过get方法来获得他的值，判断是否为空。
        if (redisTemplate.opsForValue().get(key) == null) {
            return false;
        }else{
            return true;
        }
    }

    @Override
    public Boolean delete(String key) {
       redisTemplate.delete(key);
       if (redisTemplate.opsForValue().get(key) == null) {
return true;
       }
return false;
   }


    @Override
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }
}
