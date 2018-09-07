package com.iceneet.untils;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

public class RedisUntils {
    public static boolean SetByte(RedisTemplate template,String Key,byte[] byt,long time){
        if (template==null){
            return false;
        }else {
            try{
                template.execute(new RedisCallback() {
                    @Override
                    public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                        return redisConnection.setNX(Key.getBytes(),byt);
                    }
                });
                template.expire(Key,time,TimeUnit.SECONDS);
                return true;
            }catch (Exception e){
                return false;
            }
        }
    }
    public static Object GetByte(RedisTemplate template,String Key){
        if (template==null){
            return null;
        }
        try {
            Object o = template.execute(new RedisCallback() {
                @Override
                public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                    return redisConnection.get(Key.getBytes());
                }
            });
            return o;
        }catch (Exception e){
            return null;
        }
    }
}
