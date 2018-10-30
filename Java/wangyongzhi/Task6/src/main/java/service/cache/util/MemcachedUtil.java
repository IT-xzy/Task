package service.cache.util;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.net.InetSocketAddress;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * @Description: Memcached基础工具类
 */
@Repository
public class MemcachedUtil {

    private static Logger logger = LoggerFactory.getLogger(MemcachedUtil.class);

    @Autowired(required = false)
    MemcachedClient memcachedClient;

    private static Long DEFAULT_OP_TIMEOUT = 10000L;//10min

    public static int defaultExpireTime = 24 * 60 * 60;//默认缓存1天。

    /**
     * Memcached是否可用
     *
     * @return
     * @author cl
     */
    public boolean isAvailable() {
        if (memcachedClient.isShutdown()) {
            logger.error("Memcached client has shut down!");
            return false;
        }

        Map<InetSocketAddress, String> map = null;

        try {
            map = memcachedClient.getVersions();
        } catch (Exception e) {
            logger.error("Exceptions for getting memcached server version!", e);
        }
        if (map == null || map.size() == 0) {
            logger.error("There is no suitable memcached server");
            return false;
        }
        return true;
    }

    /**
     * @param key
     * @return
     * @author cl
     */
    public Object getValue(String key) {
        Object value = null;
        try {
            value = memcachedClient.get(key);
        } catch (TimeoutException e) {
            logger.error("Cache TimeoutException", e);
        } catch (InterruptedException e) {
            logger.error("Cache InterruptedException", e);
        } catch (MemcachedException e) {
            logger.error("Cache MemcachedException", e);
        }
        return value;
    }

    /**
     * @param key
     * @param t
     * @return
     * @author cl
     */

    public <T> T getValue(String key, Class<T> t) {
        T value = null;
        try {
            value = this.memcachedClient.get(key); //this是什么作用
        } catch (TimeoutException e) {
            logger.error("Cache TimeoutException", e);
        } catch (InterruptedException e) {
            logger.error("Cache InterruptedException", e);
        } catch (MemcachedException e) {
            logger.error("Cache MemcachedException", e);
        }
        return value;
    }


    /**
     * 在cache中保存value
     *
     * @param key
     * @param value
     * @author cl
     */

    public void setValue(String key, Object value) {
        try {
            memcachedClient.set(key, defaultExpireTime, value);
        } catch (TimeoutException e) {
            logger.error("Cache TimeoutException", e);
        } catch (InterruptedException e) {
            logger.error("Cache InterruptedException", e);
        } catch (MemcachedException e) {
            logger.error("Cache MemcachedException", e);
        }
    }

    /**
     * 在cache中保存value
     *
     * @param key
     * @param value
     * @param exp   表示被保存的时长，单位:秒
     * @author cl
     */

    public void setValue(String key, int exp, Object value) {
        try {
            memcachedClient.set(key, exp, value);
        } catch (TimeoutException e) {
            logger.error("Cache TimeoutException", e);
        } catch (InterruptedException e) {
            logger.error("Cache InterruptedException", e);
        } catch (MemcachedException e) {
            logger.error("Cache MemcachedException", e);
        }
    }

    /**
     * 删除cache保存的value
     *
     * @param key
     * @return
     * @author cl
     */

    public Boolean remove(String key) {
        try {
            return memcachedClient.delete(key, DEFAULT_OP_TIMEOUT);
        } catch (TimeoutException e) {
            logger.error("Cache TimeoutException", e);
        } catch (InterruptedException e) {
            logger.error("Cache InterruptedException", e);
        } catch (MemcachedException e) {
            logger.error("Cache MemcachedException", e);
        }
        return Boolean.FALSE;
    }

    /**
     * 删除cache保存的value,设置超时时间
     *
     * @param key
     * @param opTimeout
     * @return
     * @author cl
     */

    public Boolean remove(String key, Long opTimeout) {
        try {
            return memcachedClient.delete(key, opTimeout);
        } catch (TimeoutException e) {
            logger.error("Cache TimeoutException", e);
        } catch (InterruptedException e) {
            logger.error("Cache InterruptedException", e);
        } catch (MemcachedException e) {
            logger.error("Cache MemcachedException", e);
        }
        return Boolean.FALSE;
    }

    public MemcachedClient getMemcachedClient(){
        return memcachedClient;
    }

    public void setMemcachedClient(MemcachedClient memcachedClient){
        this.memcachedClient = memcachedClient;
    }


}
