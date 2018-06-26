package com.ptt.util;

import com.whalin.MemCached.MemCachedClient;
import com.whalin.MemCached.SockIOPool;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @ClassName: MemcacheUtil
 * @Description: 由于其构造方法是protected，所以只能调用getInstance()方法实例化对象，并且实例的时候先执行静态块中的内
 * 容，即创建MemcacheUtil实例之前就已经建立好了连接池。
 * @Author: Jin
 * @CreateDate: 2018/6/5 20:03
 * @Version: 1.0
 */
@Component
public class MemcacheUtil {
    //新建缓存实例
    private static MemCachedClient memCachedClient = new MemCachedClient();

    static {
        String[] servers = {"47.98.174.155:11211"};//缓存服务，可以是多个
        Integer[] weight = {1};//服务的权重，与服务一一对应
        SockIOPool pool = SockIOPool.getInstance();//创建连接池
        //设置连接池信息
        pool.setServers(servers);
        pool.setWeights(weight);
        pool.setFailover(true);
        pool.setInitConn(3);
        pool.setMinConn(3);
        pool.setMaxConn(100);
        //初始化连接池
        pool.initialize();
    }

    protected MemcacheUtil() {
    }

    protected static MemcacheUtil memcacheUtil = new MemcacheUtil();

    /**
     * @Description: 通过此方法实例MemcacheUtil。实例的时候会先执行静态块中的内容，创建一个连接池。
     * @return: com.ptt.util.MemcacheUtil
     * @Date: 2018/6/5 21:41
     */
    public static MemcacheUtil getInstance() {
        return memcacheUtil;
    }

    /**
     * @Description: 新增缓存
     * @return: boolean
     * @Date: 2018/6/5 21:48
     */
    public boolean add(String key, Object value) {
        return memCachedClient.add(key, value);
    }

    /**
     * @Description: 新增有过期时间的缓存
     * @return: boolean
     * @Date: 2018/6/5 21:49
     */
    public boolean add(String key, Object value, Date exp) {
        return memCachedClient.add(key, value, exp);
    }

    /**
     * @Description: 通过键查找缓存值
     * @return: java.lang.Object
     * @Date: 2018/6/5 21:50
     */
    public Object getValue(String key) {
        return memCachedClient.get(key);
    }

    /**
     * @Description: 判断缓存是否存在
     * @return: boolean
     * @Date: 2018/6/5 21:50
     */
    public boolean exist(String key) {
        return memCachedClient.keyExists(key);
    }
    public void update(String key, Object value){
        memCachedClient.replace(key, value);
    }
}
