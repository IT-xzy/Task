package com.jnshu.Utils;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeoutException;

@Component
public class XMemcachedUtil {
    @Resource
    private XMemcachedClientBuilder memcachedClientBuilder;
    @Resource
    private MemcachedClient memcachedClient;

    public XMemcachedUtil() {
    }

    /**
     * public void init() {
     * xMemcachedUtil = this;
     * xMemcachedUtil.memcachedClient = this.memcachedClient;
     * xMemcachedUtil.memcachedClientBuilder = this.memcachedClientBuilder;
     * }
     */
    private MemcachedClient createClient() throws Exception {
        if (memcachedClient == null) {//如果spring没有创建成功，再build一次
            return memcachedClient = memcachedClientBuilder.build();
        }
        return null;
    }

    public void addCache(String name, int time, Object o) {
        try {
            createClient();
            memcachedClient.add(name, time, SerializeUtil.serizlize(o));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Object getCache(String name) {
        try {
            createClient();
            byte[] nameValue = memcachedClient.get(name);
            if (nameValue != null) {
                return SerializeUtil.deserialize(nameValue);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteCache(String name) {
        try {
            createClient();
            memcachedClient.delete(name);
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (MemcachedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void fullCache(){
        try {
            createClient();
            memcachedClient.flushAll();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
