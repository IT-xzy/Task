package com.ptteng.CahcheUtil;


import com.whalin.MemCached.MemCachedClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("MemCacheImpl")
public class MemCacheImpl implements CacheDao {

    @Autowired
    private MemCachedClient memCachedClient;

    @Override
    public Boolean add(String key, Object value) {
        Boolean flag=memCachedClient.add(key,value);
        return flag;
    }

    @Override
    public Boolean set(String key, Object value) {
        Boolean flag=memCachedClient.set(key,value);
        return flag;
    }

    @Override
    public Boolean delete(String key) {
        Boolean flag=memCachedClient.delete(key);
        return flag;
    }

    @Override
    public Boolean replace(String key, Object value) {
        Boolean flag=memCachedClient.replace(key,value);
        return flag;
    }

    @Override
    public Object get(String key) {
        return memCachedClient.get(key);
    }

    @Override
    public Boolean flush() {
        return memCachedClient.flushAll();
    }
}
