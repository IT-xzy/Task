package com.ptteng.manager;

import com.ptteng.pojo.exception.UnacceptableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component("redis")
public class Redis {
    //注入redis操作类
    @Autowired
    private RedisTemplate redis;
    @Autowired
    private HashOperations hs;

    public void reportAlive(){
        put("server","a","success",1L);
    }

    @SuppressWarnings("unchecked")
    public boolean haskey(String ok, String hk) {
        try {
            return hs.hasKey(ok, hk);
        } catch (Throwable e) {
            e.printStackTrace();
            throw new UnacceptableException("页面繁忙，请刷新重试");
        }
    }

    /**
     * 增加缓存
     *
     * @param ok   object key      大key
     * @param hk   objecthash key  小key
     * @param obj  需要缓存的对象
     * @param time 缓存存在时间,这里只能设置大key的存在时间
     * @return 返回是否添加成功
     */
    @SuppressWarnings("unchecked")
    public boolean put(String ok, String hk, Object obj, Long time) {
        try {
            hs.put(ok, hk, obj);
            if (time > 0) {
                redis.expire(ok, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Throwable e) {
            e.printStackTrace();
            throw new UnacceptableException("页面繁忙，请刷新重试");
        }
    }

    /**
     * 获取缓存
     *
     * @param ok object key      大key
     * @param hk objecthash key  小key
     * @return 返回该缓存
     */
    @SuppressWarnings("unchecked")
    public Object get(String ok, String hk) {
        try {
            return hs.get(ok, hk);
        } catch (Throwable e) {
            e.printStackTrace();
            throw  new UnacceptableException("页面繁忙，请刷新重试");
        }
    }

    /**
     * 删除缓存
     *
     * @param ok       object Key 大key
     * @param hashKyes hask keys 小key数组,传入多少个删除多少个.
     * @return
     */
    @SuppressWarnings("unchecked")
    public Long del(String ok, String... hashKyes) {
        try {
            if (hashKyes == null) {
                redis.delete(ok);
                return 1L;
            }
            return hs.delete(ok, hashKyes);

        } catch (Throwable e) {
            e.printStackTrace();
            throw new UnacceptableException("页面繁忙，请刷新重试");
        }
    }
}
