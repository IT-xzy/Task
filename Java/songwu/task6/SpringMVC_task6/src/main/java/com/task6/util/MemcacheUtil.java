package com.task6.util;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Create by SongWu on 2018/7/26
 */
@Component
public class MemcacheUtil {
    @Autowired
    private MemcachedClientBuilder memcachedClientBuilder;

    @Autowired
    private MemcachedClient memcachedClient;

    public MemcacheUtil() {
    }

    private MemcachedClient createClient() {
        if (memcachedClient == null) {
            try {
                return memcachedClient = memcachedClientBuilder.build();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return memcachedClient;
    }


    public void setCache(String name, int time, Object o) {
        try {
            memcachedClient.set(name, time, o);
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (MemcachedException e) {
            e.printStackTrace();
        }
    }


    public void addCache(String name, int time, Object o) {
        try {
            memcachedClient.add(name, time, o);
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (MemcachedException e) {
            e.printStackTrace();
        }
    }


    public Object getCache(String name) {
        Object value = null;
        try {
            value = memcachedClient.get(name);
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (MemcachedException e) {
            e.printStackTrace();
        }

        return value;
    }


    public void deleteCache(String name) {
        try {
            memcachedClient.delete(name);
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (MemcachedException e) {
            e.printStackTrace();
        }
    }

    public void fullCache() {
        try {
            memcachedClient.flushAll();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (MemcachedException e) {
            e.printStackTrace();
        }
    }

}
