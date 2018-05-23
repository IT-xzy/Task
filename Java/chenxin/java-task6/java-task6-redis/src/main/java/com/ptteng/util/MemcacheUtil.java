package com.ptteng.util;

import com.whalin.MemCached.MemCachedClient;
import com.whalin.MemCached.SockIOPool;
public class MemcacheUtil {
    private static MemCachedClient memcachedClient = new MemCachedClient();

    static {
//        try {
//            memcachedClient = new MemcachedClient(new InetSocketAddress("127.0.0.1",11211));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }2018年5月11日10点32分
        //设置缓存服务器列表，当使用分布式缓存时，可以指定多个缓存服务器
        String[] servers = {
          //server.domain.com:11211
                "127.0.0.1:11211"
        };
        //设置服务器权重
        Integer[] weights ={3, 2};
        //创建一个socket连接池实例，获取socket连接池的实例对象
        SockIOPool pool= SockIOPool.getInstance();
        //向连接池设置服务器和权重
        pool.setServers(servers);
        pool.setWeights(weights);

        //设置初始连接数，最小及最大连接数，最大处理时间。
        pool.setInitConn(5);
        pool.setMinConn(5);
        pool.setMaxConn(250);
        pool.setMaxIdle(1000*60*60*6);
        //设置主线程的睡眠时间
        pool.setMaintSleep(30);

        //设置TCP的参数，连接超时等
        pool.setNagle(false);
        pool.setSocketTO(3000);
        pool.setSocketConnectTO(0);

        //初始化连接池
        pool.initialize();
    }
    //add key-value键值对
    public void saveKyeAndValue(String key, Object object){
        memcachedClient.set(key,object);
    }
    //通过key取得value
    public Object getValue(String key){
        return memcachedClient.get(key);
    }
    public boolean isExist(String key){
        System.out.println(memcachedClient.keyExists(key));
        return memcachedClient.keyExists(key);
    }
}
