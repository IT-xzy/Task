package com.jnshu.myutils;

import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;

import java.util.Date;

public class MemCachedManager {

    // 创建全局的唯一实例
    protected static MemCachedClient memcacheClient = new MemCachedClient() ;

    protected static MemCachedManager memCachedManager = new MemCachedManager();

    // 设置与缓存服务器的连接池
    static {
//设置服务器列表
        //使用的服务器，由于是在本地测试，只有一个服务器地址。默认端口是11211
        //格式为 服务器IP:端口号
        String[] servers = {"127.0.0.1:11211"};
        /**
         * 设置权重，与设定的服务器一一对应
         */
        Integer[] weights = {3};
        //第二、memcached的pool可以关联多个server，
        //String[] servers = {"10.20.185.12:11001","10.20.185.25:11001"};
        //Integer[] weights = {3,7};

        // 获取socke连接池的实例对象，建立通信的连接池
        SockIOPool pool = SockIOPool.getInstance();

        // 设置服务器信息
        pool.setServers(servers);
        pool.setWeights(weights);

        // 设置初始连接数、最小和最大连接数
        pool.setInitConn(5);
        pool.setMinConn(5);
        pool.setMaxConn(250);
        //设置可用连接的最长等待时间
        pool.setMaxIdle(1000 * 60 * 60 * 6);

        //设置连接池维护线程的睡眠时间，设置为0，维护线程不启动
        pool.setMaintSleep(30);

        // 设置TCP的参数，连接超时等

        //设置Nagle算法，设置为false，因为通讯数据量比较大要求响应及时
        pool.setNagle(false);
        //设置socket读取等待超时时间
        pool.setSocketTO(3000);
        //设置连接等待超时值
        pool.setSocketConnectTO(0);

        //设置完参数后，启动pool
        pool.initialize();

    }

    protected MemCachedManager() {

    }

    public static MemCachedManager getInstance() {
        return memCachedManager;
    }

    public boolean set(String key, Object value) {
        return memcacheClient.set(key, value);
    }

    public boolean add(String key, Object value) {
        return memcacheClient.add(key, value);
    }

    public boolean add(String key, Object value, Date expiry) {
        return memcacheClient.add(key, value, expiry);
    }

    public boolean replace(String key, Object value) {
        return memcacheClient.replace(key, value);
    }

    public boolean replace(String key, Object value, Date expiry) {
        return memcacheClient.replace(key, value, expiry);
    }

    public Object get(String key) {
        return memcacheClient.get(key);
    }

    public boolean flush() {
        return memcacheClient.flushAll();
    }

    public boolean flush(String[] params) {
        return memcacheClient.flushAll(params);
    }

  /*  public static void main(String[] args) {
        MemCachedManager cache = MemCachedManager.getInstance();
        cache.add("hello", 234);
        System.out.println("get value : " + cache.get("hello"));

        // 操作对象
        Person tb = new Person();
        cache.add("bean", tb);

        Person tb1 = (Person) cache.get("bean");
        System.out.println(tb1);

        tb1.setNAME("嘻嘻呼呼哈哈璐璐");
        cache.set("bean", tb1);
        tb1 = (Person) cache.get("bean");
        System.out.println(tb1);

    }*/
}