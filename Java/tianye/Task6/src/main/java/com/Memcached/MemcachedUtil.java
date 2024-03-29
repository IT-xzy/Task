package com.Memcached;

import com.whalin.MemCached.MemCachedClient;
import com.whalin.MemCached.SockIOPool;

public class MemcachedUtil {
    /**
     * memcached客户端单例
     */
    private static MemCachedClient cachedClient =new MemCachedClient();
     /**
      * 初始化连接池
      */
     static {
         //获取连接池实例
         SockIOPool pool =SockIOPool.getInstance();
         //服务器列表及其权重
         String[] servers = {"127.0.0.1:11211"};
         Integer[] weights = {3};

         //设置服务器信息
         pool.setServers(servers);
         pool.setWeights(weights);

         //设置初始连接数、最小连接数、最大连接数、最大处理时间
         pool.setInitConn(10);
         pool.setMinConn(10);
         pool.setMaxConn(1000);
         pool.setMaxIdle(1000*60*60);

         //设置连接池守护线程的睡眠时间
         pool.setMaintSleep(60);

         //设置TCP参数，连接超时
         pool.setNagle(false);
         pool.setSocketTO(60);
         pool.setSocketConnectTO(0);

         //初始化并启动连接池
         pool.initialize();


     }

    private MemcachedUtil(){
    }
    public static boolean add(String key ,Object value){
         return cachedClient.add(key, value);
    }
    public static boolean add(String key ,Object value,Integer expire){
         return cachedClient.add(key, value, expire);
    }
    public static boolean put(String key, Object value) {
        return cachedClient.set(key, value);
    }

    public static boolean put(String key, Object value, Integer expire) {
        return cachedClient.set(key, value, expire);
    }

    public static boolean replace(String key, Object value) {
        return cachedClient.replace(key, value);
    }

    public static boolean replace(String key, Object value, Integer expire) {
        return cachedClient.replace(key, value, expire);
    }

    public static Object get(String key) {
        return cachedClient.get(key);
    }

}

