package com.ptteng.CahcheUtil;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;


@Service("RedisImpl")
public class RedisImpl implements CacheDao {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Boolean add(String key, Object value) {
        return null;
    }

    @Override
    public Boolean set(String key, Object value) {
        boolean flag = false;
        try {
            ValueOperations operations = redisTemplate
                    .opsForValue();
            operations.set(key, value);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
//    删除缓存
    public Boolean delete(String key) {
           redisTemplate.delete(key);
        return null;
    }


    @Override
    public Boolean replace(String key, Object value) {
        return null;
    }

    @Override
//   根据key获取缓存中的value
    public Object get(String key) {
        Object value;
        ValueOperations operations = redisTemplate
                .opsForValue();
        value = operations.get(key);
        return value;
    }

    @Override
    public Boolean flush() {
        return null;
    }
}
