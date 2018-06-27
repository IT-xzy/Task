package cached;

import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;

import java.util.Date;

public class Memcached {

    private static MemCachedClient memcachedClient = new MemCachedClient();
    private static Memcached memcached = new Memcached();

    static {
        //缓存服务器列表
        String[] servers = {"127.0.0.1:11211"};
        //服务器权重
        Integer[] weights = {3};
        //创建一个sock连接池实例
        SockIOPool pool = SockIOPool.getInstance();

//设置服务器信息
        pool.setServers(servers);
        pool.setWeights(weights);

        //设置初始连接数、最小连接数、最大连接数、最大处理时间
        pool.setInitConn(15);
        pool.setMinConn(15);
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
    private Memcached(){}
    public static Memcached getMemcached(){
        return memcached;
    }

    public static boolean add(String key, Object value,int expire) {
        return memcachedClient.set(key, value, expire);
    }

    public static boolean add(String key,Object value){
        return  memcachedClient.set(key,value);
    }

    public static Object get(String key) {
        return memcachedClient.get(key);
    }

    public static boolean replace(String key, Object value) {
        return memcachedClient.replace(key, value);
    }

    public static boolean replace(String key, Object value, Date expiry) {
        return memcachedClient.replace(key, value, expiry);
    }

    public static boolean delete(String key) {
        return memcachedClient.delete(key);
    }

    public static void main(String[] args) {
            //将对象加入到memcached缓存
            memcachedClient.add("keke", "This is a test String");
            //从memcached缓存中按key值取对象
    memcachedClient.delete("jobList");
        }

}