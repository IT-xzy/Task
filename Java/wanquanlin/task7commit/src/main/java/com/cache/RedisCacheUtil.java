package com.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @Author: Jaime
 * @Date: 2018/5/1 6:50
 * @Description: *
 */

public class RedisCacheUtil {
    @Autowired
    private RedisTemplate redisTemplate;
    /**
      * 向Hash中添加值
      * @param key      可以对应数据库中的表名
       * @param field    可以对应数据库表中的唯一索引
      * @param obj    存入redis中的值
      */
 public void hset(String key, String field, Object obj,int extime) {
     if(key == null || "".equals(key)){
             return ;
         }
     redisTemplate.opsForHash().put(key, field, obj);
     redisTemplate.expire(key,extime, TimeUnit.SECONDS);
 }

 /**
      * 从redis中取出值
      * @param key
      * @param field
      * @return
      */
  public <T> T hget(String key, String field){
      if(key == null || "".equals(key)){
              return null;
          }
      return (T) redisTemplate.opsForHash().get(key, field);
  }

      /**
      * 判断 是否存在 key 以及 hash key
      * @param key
      * @param field
      * @return
      */
       public boolean hexists(String key, String field){
       if(key == null || "".equals(key)){
               return false;
           }
       return redisTemplate.opsForHash().hasKey(key, field);
   }

   /**
      * 查询 key中对应多少条数据
      * @param key
      * @return
      */
  public long hsize(String key) {
      if(key == null || "".equals(key)){
              return 0L;
          }
      return redisTemplate.opsForHash().size(key);
  }

  /**
      * 删除
      * @param key
      * @param field
      */
    public void hdel(String key, String field) {
        if(key == null || "".equals(key)){
                return;
            }
        redisTemplate.opsForHash().delete(key, field);
    }

    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public RedisTemplate getRedisTemplate() {
        return redisTemplate;
    }
}

