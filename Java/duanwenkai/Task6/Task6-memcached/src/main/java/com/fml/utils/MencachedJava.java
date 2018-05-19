package com.fml.utils;


import net.spy.memcached.MemcachedClient;

import java.net.InetSocketAddress;

/**
 * 测试本地memcached服务是否启动
 */
public class MencachedJava {
    public static void main(String[] args) {
        try{
            // 本地连接 Memcached 服务
            MemcachedClient mcc = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
            System.out.println("Connection to server sucessful.");

            // 关闭连接
            mcc.shutdown();
            System.out.println("Connection to server sucessful.");
        }catch(Exception ex){
            System.out.println( ex.getMessage() );
        }
    }
}
