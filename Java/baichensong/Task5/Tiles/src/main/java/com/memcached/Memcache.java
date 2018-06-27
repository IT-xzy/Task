//例子二
// package com.memcached;
//
//import com.danga.MemCached.MemCachedClient;
//import com.danga.MemCached.SockIOPool;
//
//public class Memcache {
//
//    protected static Memcache mc = new Memcache();
//
//    protected MemCachedClient mcc = new MemCachedClient();
//
//    static{
//        //设置缓存服务器列表，当时用分布式缓存时，可以指定多个缓存服务器。这里应该设置为多个不同的服务
//        String[] servers = {"127.0.0.1:11211"};
//        //String[] servers = {"192.168.71.195:12000"};
//        //设置服务器权重
//        Integer[] weights = {3};
//
//        //创建一个socked连接池的实例对象
//        SockIOPool pool = SockIOPool.getInstance();
//
//        //设置服务器信息
//        pool.setServers(servers);          //设置memcached服务器地址
//        pool.setWeights(weights);          // 设置每个服务器的权重
//
//        //设置初始连接数、最小最大连接数、最大处理时间
//        pool.setInitConn(5);               // 初始化对每个服务器建立的连接数目
//        pool.setMinConn(5);                //每个服务器建立的最小连接数
//        pool.setMaxConn(250);              //每个服务器建立的最大连接数
//        pool.setMaxIdle(1000*60*60*6);      //设置最大处理时间
//
//        //设置主线程的睡眠时间
//        pool.setMaintSleep(30);
//
//        pool.setNagle(false); //socket 的参数如果true在写数据时不缓冲，立即发送出去。Tcp的规则是在发送一个包之前，
//        // 包的发送方会等待远程接收方确认已收到上一次发送过来的包；这个方法就可以关闭套接字的缓存——包准备立即发出。
//        pool.setSocketTO(30);           //socket  阻塞读取数据的超时时间
//        pool.setSocketConnectTO(0);     // 连接建立时对超时的控制
//
//
//        pool.initialize();              //  初始化连接池
//
//        //压缩设置，超过制定大小（单位K）的数据都会压缩
//        //mcc.setCompressEnable(false);
//        //mcc.setCompressThreshold(64*1024);
//    }
//
//    //保护构造函数，不允许实例化
//    protected Memcache(){}
//
//    public static Memcache getInstance(){
//        return mc;
//    }
//
//    public MemCachedClient getClient(){
//        return mcc;
//    }
//}