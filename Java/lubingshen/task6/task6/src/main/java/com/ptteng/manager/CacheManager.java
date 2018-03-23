package com.ptteng.manager;


import com.ptteng.pojo.exception.CacheException;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeoutException;

@Component
public class CacheManager {
    @Autowired
    MemcachedClient memcachedClient;
    //缓存存活时间 单位秒
    private static final int ALIVE = 60 * 60;
    //超时时间 单位毫秒
    private static final long LIMIT = 10000L;

    public Object getDataByCache(String key){
        try {
            return memcachedClient.get(key,LIMIT);
        } catch (TimeoutException | InterruptedException | MemcachedException e) {
            throw  new CacheException(e.getClass().getSimpleName());
        }
    }

    public void addDataIntoCache(String key, Object data){

        try {
            if(memcachedClient.set(key,ALIVE,data))
                return;
        } catch (TimeoutException | InterruptedException | MemcachedException e) {
            throw  new CacheException(e.getClass().getSimpleName());
        }

        throw new CacheException("Unknown reason");
    }

}
