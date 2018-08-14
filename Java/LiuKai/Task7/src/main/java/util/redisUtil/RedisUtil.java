package util.redisUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {
    @Autowired
  RedisTemplate redisTemplate;
    //设置过期时间，单位为毫秒,设置过期时间30分钟
//    private static final long OUTTIMEE = 30 * 60 * 1000;


    /**
     * @Description 添加缓存
     * @Param 传入key value 过期时间，设置时间单位为分钟
     * @return void
     **/
    public void setRedis(Object key,long outtime, Object value) {
        redisTemplate.opsForValue().set(key, value, outtime, TimeUnit.MINUTES);
    }



    /**
     * @Description 读取缓存
     * @Param key
     * @return  object
     **/
    public Object getRedis(Object key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * @Description 删除缓存
     * @Param key
     * @return void
     **/
    public void delete(Object key) {
        redisTemplate.delete(key);
    }



}
