package com.tool;

import com.danga.MemCached.MemCachedClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.Date;

public class MemCachedManager {

    // 创建全局的唯一实例
    private static MemCachedClient mcc ;

    private static MemCachedManager memCachedManager = new MemCachedManager();

    // 通过配置文件的方式在静态代码块中初始化MemCachedClient
    // TODO: 2018/8/1 初始化方法
    static {
        ApplicationContext atx = new ClassPathXmlApplicationContext("spring-memcache.xml");
        mcc = (MemCachedClient)atx.getBean("memCachedClient");
    }

    /**
     * 保护型构造方法，不允许实例化！
     */
    private MemCachedManager() {
    }

    /**
     * 获取唯一实例.
     */
    public static MemCachedManager getMemCachedManager(){return memCachedManager;}
    public static MemCachedClient getInstance() {
        return mcc;
    }

    /**
     * 添加一个指定的值到缓存中.
     */
    //add方法
    public boolean add(String key, Object value) {
        return mcc.add(key, value);
    }
    public boolean add(String key, Object value, Date expiry) {
        return mcc.add(key, value, expiry);
    }

    //rtplace方法
    public boolean replace(String key, Object value) { return mcc.replace(key, value); }
    public boolean replace(String key, Object value, Date expiry) {
        return mcc.replace(key, value, expiry);
    }

    //set方法
    public boolean set(String key,Object value){
        return mcc.set(key,value);
    }
    public boolean set(String key,Object value,Date expiry){
        return mcc.set(key,value,expiry);
    }
    //delete方法
    public boolean delete(String key){
        return mcc.delete(key);
    }
    //get方法
    public Object get(String key) {
        return mcc.get(key);
    }

    public static void main(String[] args) {
        mcc.set("Testkey","123",new Date(1000*10));
        System.out.println(mcc.get("Testkey"));
    }
}
