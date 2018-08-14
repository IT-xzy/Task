package wyq.webapp.util;

import com.whalin.MemCached.*;
import wyq.webapp.pojo.Engineer;

import java.util.Date;

public class MemcacheManager {
    static MemCachedClient cachedClient;

    static MemcacheManager INSTANCE = new MemcacheManager();

    MemcacheManager(){
        cachedClient = new MemCachedClient();

        SockIOPool pool = SockIOPool.getInstance();

        String[] servers = {"139.199.127.53:11211"};

        pool.setServers(servers);
        pool.setFailover(true);
        pool.setInitConn(10); // 设置初始连接
        pool.setMinConn(5);// 设置最小连接
        pool.setMaxConn(250); // 设置最大连接
        pool.setMaxIdle(1000 * 60 * 60 * 3); // 设置每个连接最大空闲时间3个小时
        pool.setMaintSleep(30);
        pool.setNagle(false);
        pool.setSocketTO(3000);
        pool.setAliveCheck(true);
        pool.initialize();
    }

    public static MemcacheManager getInstance(){
        return INSTANCE;
    }

    public void add(String key, Object value) {
        cachedClient.set(key, value);
    }

    public void add(String key, Object value, int milliseconds) {
        cachedClient.set(key, value, milliseconds);
    }

    public void remove(String key) {
        cachedClient.delete(key);
    }

    public void remove(String key, int milliseconds) {
        cachedClient.delete(key, milliseconds, new Date());
    }

    public void update(String key, Object value, int milliseconds) {
        cachedClient.replace(key, value, milliseconds);
    }

    public void update(String key, Object value) {
        cachedClient.replace(key, value);
    }

    public Object get(String key) {
        return cachedClient.get(key);
    }

//    public static void main(String[] args){
//        Engineer engineer = new Engineer();
//        engineer.setId(123);
//        engineer.setCreateTime(123);
//        cachedClient.add("obj",engineer);
//        Engineer result = (Engineer) cachedClient.get("obj");
//        System.out.println(result);
//    }
}
