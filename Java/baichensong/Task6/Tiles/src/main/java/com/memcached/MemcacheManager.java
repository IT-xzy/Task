//package com.memcached;
//
//
//import com.danga.MemCached.MemCachedClient;
//import com.danga.MemCached.SockIOPool;
//
//import java.util.Date;
//
///*
// * 客户端工具类
// */
//public class MemcacheManager {
//
//    // 创建全局的唯一实例
//    private static MemCachedClient memcachedClient;
//
//    private static MemcacheManager memcachedManager = new MemcacheManager();
//
//    static {
//        // 设置缓存服务器列表，当使用分布式缓存的时，可以指定多个缓存服务器。这里应该设置为多个不同的服务
//        String[] servers = {"127.0.0.1:11211"};
//        // 设置服务器权重
//        Integer[] weights = {3};
//        // 创建一个Socked连接池实例
//        SockIOPool sockIOPool = SockIOPool.getInstance();
//
//        sockIOPool.setServers(servers);// 设置memcached服务器地址
//        sockIOPool.setWeights(weights);// 设置每个MemCached服务器权重
//      // sockIOPool.setFailover(true); // 当一个memcached服务器失效的时候是否去连接另一个memcached服务器.
//        sockIOPool.setInitConn(10); // 初始化时对每个服务器建立的连接数目
//        sockIOPool.setMinConn(10); // 每个服务器建立最小的连接数
//        sockIOPool.setMaxConn(100); // 每个服务器建立最大的连接数
//        sockIOPool.setMaintSleep(30);// 自查线程周期进行工作，其每次休眠时间
//        sockIOPool.setNagle(false); // Socket的参数，如果是true在写数据时不缓冲，立即发送出去。Tcp的规则是在发送一个包之前，包的发送方会等待远程接收方确认已收到上一次发送过来的包；这个方法就可以关闭套接字的缓存——包准备立即发出。
//        sockIOPool.setSocketTO(3000);// Socket阻塞读取数据的超时时间
//        sockIOPool.setAliveCheck(true);// 设置是否检查memcached服务器是否失效
//        sockIOPool.setMaxIdle(1000 * 30 * 30);// 设置最大处理时间
//        sockIOPool.setSocketConnectTO(0);// 连接建立时对超时的控制
//        sockIOPool.setMaintSleep(30);// 设置主线程睡眠时间，每30秒苏醒一次，维持连接池大小
//
//        sockIOPool.initialize();// 初始化连接池
//        if (memcachedClient == null) {
//            memcachedClient = new MemCachedClient();
//        }
//        // 压缩设置，超过指定大小（单位为K）的数据都会被压缩
//        //memcachedClient.setCompressEnable(true);
//       // memcachedClient.setCompressThreshold(64 * 1024);
//    }
//
////    /**
////     * 获取唯一实例.
////     *
////     * @return
////     */
//    public static MemcacheManager getInstance() {
//        return memcachedManager;
//    }
//
//    private MemcacheManager() {
//    }
//
//    /*
//     * 向缓存添加键值对并为该键值对设定逾期时间（即多长时间后该键值对从Memcached内存缓存中删除，比如： new
//     * Date(1000*10)，则表示十秒之后从Memcached内存缓存中删除）。
//     * 设置过期时间：设置10分钟后过期，是应该设置date为System.currentTimeInMillis()+10*60*1000
//     * 还是10*60*1000 服务端是两种方式都兼容的，一个是多少秒后过期，一个是什么时候过期， 但后者因为设置时间是在客户端，
//     * 存储在服务端，假如两台服务器时间差别很大，就会导致数据的过期时间和我要求的时间点不符合。
//     *
//     */
//    public  boolean add(String key, Object value, Date expire) {
//        return memcachedClient.add(key, value, expire);
//    }
//
//    /*
//     * 根据键获取Memcached内存缓存管理系统中相应的值
//     */
//    public static Object get(String key) {
//        return memcachedClient.get(key);
//    }
//
//    public boolean replace(String key, Object value) {
//        return memcachedClient.replace(key, value);
//    }
//    public boolean replace(String key, Object value, Date expiry) {
//        return memcachedClient.replace(key, value, expiry);
//    }
//
//}
//
