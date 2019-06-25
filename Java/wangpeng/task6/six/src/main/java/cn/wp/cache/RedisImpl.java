package cn.wp.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/** @ClassName: @Description: @Author: 老王 @Date: 2019/5/31 19:39 @Version: 1.0 */
@Service("Redis")
public class RedisImpl implements Cached {

    @Autowired RedisTemplate redisTemplate;

    @Override
    public Boolean set(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
        if (redisTemplate.opsForValue().get(key) != null) {
            return true;
        }
        return false;
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
