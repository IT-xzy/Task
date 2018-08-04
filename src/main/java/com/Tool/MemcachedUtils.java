package com.Tool;

import com.whalin.MemCached.MemCachedClient;
import com.whalin.MemCached.SockIOPool;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

public final class MemcachedUtils {
    private  static   MemCachedClient cachedClient=new MemCachedClient();

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
    private MemcachedUtils(){
    }

    public MemcachedUtils(MemCachedClient cachedClient) {
    }


    /**
     * 向缓存添加新的键值对。如果键已经存在，则之前的值将被替换.
     * @param key
     * @param value
     * @return
     */
    public static boolean set(String key, Object value) {
        return setExp(key, value, null);
    }
    /**
     * 向缓存添加新的键值对。如果键已经存在，则之前的值将被替换.
     * @param key 键
     * @param value 值
     * @param expire 过期时间 New Date(1000*10)：十秒后过期
     * @return boolean
     */
    public static boolean set(String key, Object value, Date expire) {
        return setExp(key, value, expire);
    }
    /**
     * 向缓存添加新的键值对。如果键已经存在，则之前的值将被替换.
     * @param key 键
     * @param value 值
     * @param expire 过期时间 New Date(1000*10)：十秒后过期
     * @return boolean
     */
    private static boolean setExp(String key, Object value, Date expire) {
        boolean flag = false;
        try {
            flag = cachedClient.set(key, value, expire);
        } catch (Exception e) {
            MemcachedLog.writeLog("Memcached set方法报错，key值：" + key + "\r\n" + exceptionWrite(e));
        }
        return flag;
    }
    /**
     * 仅当缓存中不存在键时，add 命令才会向缓存中添加一个键值对.
     * @param key 键
     * @param value 值
     * @return boolean
     */
    public static boolean add(String key, Object value) {
        return addExp(key, value, null);
    }
    /**
     * 仅当缓存中不存在键时，add 命令才会向缓存中添加一个键值对.
     * @param key 键
     * @param value 值
     * @param expire 过期时间 New Date(1000*10)：十秒后过期
     * @return boolean
     */
    public static boolean add(String key, Object value, Date expire) {
        return addExp(key, value, expire);
    }
    /**
     * 仅当缓存中不存在键时，add 命令才会向缓存中添加一个键值对.
     * @param key 键
     * @param value 值
     * @param expire 过期时间 New Date(1000*10)：十秒后过期
     * @return boolean
     */
    private static boolean addExp(String key, Object value, Date expire) {
        boolean flag = false;
        try {
            flag = cachedClient.add(key, value, expire);
        } catch (Exception e) {
            MemcachedLog.writeLog("Memcached add方法报错，key值：" + key + "\r\n" + exceptionWrite(e));
        }
        return flag;
    }
    /**
     * 仅当键已经存在时，replace 命令才会替换缓存中的键.
     * @param key 键
     * @param value 值
     * @return boolean
     */
    public static boolean replace(String key, Object value) {
        return replaceExp(key, value, null);
    }
    /**
     * 仅当键已经存在时，replace 命令才会替换缓存中的键.
     * @param key 键
     * @param value 值
     * @param expire 过期时间 New Date(1000*10)：十秒后过期
     * @return boolean
     */
    public static boolean replace(String key, Object value, Date expire) {
        return replaceExp(key, value, expire);
    }
    /**
     * 仅当键已经存在时，replace 命令才会替换缓存中的键.
     * @param key 键
     * @param value 值
     * @param expire 过期时间 New Date(1000*10)：十秒后过期
     * @return boolean
     */
    private static boolean replaceExp(String key, Object value, Date expire) {
        boolean flag = false;
        try {
            flag = cachedClient.replace(key, value, expire);
        } catch (Exception e) {
            MemcachedLog.writeLog("Memcached replace方法报错，key值：" + key + "\r\n" + exceptionWrite(e));
        }
        return flag;
    }
    /**
     * get 命令用于检索与之前添加的键值对相关的值.
     * @param key 键
     * @return boolean
     */
    public static Object get(String key) {
        Object obj = null;
        try {
            obj = cachedClient.get(key);
        } catch (Exception e) {
            MemcachedLog.writeLog("Memcached get方法报错，key值：" + key + "\r\n" + exceptionWrite(e));
        }
        return obj;
    }
    /**
     * 删除 memcached 中的任何现有值.
     * @param key 键
     * @return boolean
     */
    public static boolean delete(String key) {
        return deleteExp(key, null);
    }
    /**
     * 删除 memcached 中的任何现有值.
     * @param key 键
     * @param expire 过期时间 New Date(1000*10)：十秒后过期
     * @return boolean
     */
    public static boolean delete(String key, Date expire) {
        return deleteExp(key, expire);
    }
    /**
     * 删除 memcached 中的任何现有值.
     * @param key 键
     * @param expire 过期时间 New Date(1000*10)：十秒后过期
     * @return boolean
     */
    @SuppressWarnings("deprecation")
    private static boolean deleteExp(String key, Date expire) {
        boolean flag = false;
        try {
            flag = cachedClient.delete(key, expire);
        } catch (Exception e) {
            MemcachedLog.writeLog("Memcached delete方法报错，key值：" + key + "\r\n" + exceptionWrite(e));
        }
        return flag;
    }
    /**
     * 清理缓存中的所有键/值对.
     * @return boolean
     */
    public static boolean flushAll() {
        boolean flag = false;
        try {
            flag = cachedClient.flushAll();
        } catch (Exception e) {
            MemcachedLog.writeLog("Memcached flashAll方法报错\r\n" + exceptionWrite(e));
        }
        return flag;
    }
    /**
     * 返回异常栈信息，String类型.
     * @param e Exception
     * @return boolean
     */
    private static String exceptionWrite(Exception e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        pw.flush();
        return sw.toString();
    }

}

