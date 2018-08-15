package com.jnshu.service.impl;

import com.jnshu.service.ServiceCache;
import com.whalin.MemCached.MemCachedClient;
import org.oasisopen.sca.annotation.Remotable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @program: SSM_WEB_SERVER
 * @description: 缓存 Memcached实现类
 * @author: Mr.xweiba
 * @create: 2018-06-09 00:37
 **/
@Service
@Remotable
public class ServiceCacheMemImpl implements ServiceCache{
    @Autowired
    MemCachedClient memCachedClient;

    @Override
    public void delete(String key) {
        memCachedClient.delete(key);
    }

    @Override
    public void setDefault(String key, Object object) {
        memCachedClient.set(key, object);
    }

    @Override
    public void setDate(String key, Object object, Date date) {
        memCachedClient.set(key, object, date);
    }

    @Override
    public Object getKey(String key) {
        return memCachedClient.get(key);
    }
}
