package utils;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * 封装xmemcached的工具类
 */
@Component
public class XmemcachedManager {
    @Resource
    private  MemcachedClient memcachedClient;

    private static final int EXP = 60*60; //缓存有效期seconds

    /**
     * 设置缓存数据
     * @param key key
     * @param value value
     */
    public void set(String key,String value) throws InterruptedException, MemcachedException, TimeoutException {
        memcachedClient.set(key, EXP,value);
    }
    public void set(String key,Object value) throws InterruptedException, MemcachedException, TimeoutException {
        memcachedClient.set(key,EXP,value);
    }

    /**
     *替换缓存数据
     */
    public void replace(String key,String value) throws InterruptedException, MemcachedException, TimeoutException {
        memcachedClient.replace(key, EXP,value);
    }

    /**
     * 删除缓存数据
     */
    public void delete(String key) throws InterruptedException, MemcachedException, TimeoutException {
        memcachedClient.delete(key);
    }

    /**
     * 获取缓存数据
     * @param key
     * @return Object
     */
    public Object get(String key) throws InterruptedException, MemcachedException, TimeoutException {
        return memcachedClient.get(key);
    }
    public Map<String,Object> get(Collection<String> keys) throws InterruptedException, MemcachedException, TimeoutException {
        return memcachedClient.get(keys);
    }
}
