package com.util;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author Arike
 * Create_at 2018/1/18 09:21
 */
@Component
public class RedisUtil {
    //注入redis操作类
    @Autowired
    private RedisTemplate redis;
    @Autowired
    private HashOperations hs;
    private  Logger logger = Logger.getLogger(RedisUtil.class);
    
    /**
     * 判断是否存在这个对象
     * @param ok object key      大key
     * @param hk objecthash key  小key
     * @return 返回是否存在
     */
    @SuppressWarnings("unchecked")
    public boolean haskey(String ok,String hk){
        try {
            return hs.hasKey(ok, hk);
        } catch (Throwable e) {
            logger.error("查询缓存 "+ok+"-"+hk+"失败,"+"异常是"+e);
        }
        return false;
    }
    
    /**
     * 增加缓存
     * @param ok object key      大key
     * @param hk objecthash key  小key
     * @param obj 需要缓存的对象
     * @return 返回是否添加成功
     */
    @SuppressWarnings("unchecked")
    public boolean put(String ok, String hk, Object obj,Long time){
        try {
            hs.put(ok,hk,obj);
            if(time>0){
                redis.expire(ok, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Throwable e) {
            logger.error("增加缓存 "+ok+"-"+hk+"失败,"+"异常是"+e);
        }
        return false;
    }
    
    /**
     * 获取缓存
     * @param ok object key      大key
     * @param hk objecthash key  小key
     * @return 返回该缓存
     */
    @SuppressWarnings("unchecked")
    public Object get(String ok,String hk){
        try{
            return hs.get(ok,hk);
        }catch(Throwable e){
            logger.error("获取缓存 "+ok+"-"+hk+"失败,"+"异常是"+e);
        }
        return null;
    }
    
    /**
     * 删除缓存
     * @param ok object Key 大key
     * @param hashKyes hask keys 小key数组,传入多少个删除多少个.
     * @return
     */
    @SuppressWarnings("unchecked")
    public Long del(String ok,String ...hashKyes){
        try {
            if(hashKyes==null){
                redis.delete(ok);
                return 1L;
            }
           return hs.delete(ok,hashKyes);
           
        } catch (Throwable e) {
            logger.error("删除失败,"+"异常是"+e);
        }
        return 0L;
    }
}
