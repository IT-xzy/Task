package com.ptteng.util;

import org.apache.commons.lang.StringUtils;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/*基于spring和redis的redisTemplate工具类*/
@Component
public class RedisUtil {
    private static Logger logger = Logger.getLogger(String.valueOf(RedisUtil.class));
//    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * String类型存取
     * @param key 键
     * @return 值
     */
    public Object get(String key){
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    /**
     * String类型缓存保存
     * @param key 键
     * @param value 值
     * @return true:成功；false:失败
     */
    public boolean set(String key, Object value) {
        try {
            logger.info("存入redis缓存的key:"+key + ";value值非空？==>" + (value != null));
            if (StringUtils.isNotEmpty(key) && null != value) {
                redisTemplate.opsForValue().set(key, value);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
