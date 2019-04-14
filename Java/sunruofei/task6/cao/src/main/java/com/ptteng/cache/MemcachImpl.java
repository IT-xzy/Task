package com.ptteng.cache;

import com.danga.MemCached.MemCachedClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName MemcachImpl
 * @Description TODO
 * @Author 孙若飞
 * @Date 2019/2/27  17:14
 * @Version 1.0
 **/
@Service("MemCache")
public class MemcachImpl implements Cached{
    @Autowired
    MemCachedClient memCachedClient;
    @Override
    public Boolean set(String key, Object value) {
        Boolean state = memCachedClient.set(key,value);
        return state;
    }

    @Override
    public Boolean delete(String key) {
        Boolean state = memCachedClient.delete(key);
        return state;
    }

    @Override
    public Object get(String key) {
        return memCachedClient.get(key);
    }
}
