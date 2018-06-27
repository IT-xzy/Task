package com.jnshu.tools;

import com.jnshu.model.UserCustom;
import com.whalin.MemCached.MemCachedClient;
import com.whalin.MemCached.SockIOPool;
import org.apache.log4j.BasicConfigurator;

/**
 * @program: taskTwo
 * @description: Memcache测试类
 * @author: Mr.xweiba
 * @create: 2018-05-19 16:18
 **/

public class MemcacheTest {
    public static void main(String[] args) {
        BasicConfigurator.configure();
        String[] servers = { "127.0.0.1:11211"};
        SockIOPool pool = SockIOPool.getInstance();

        pool.setServers( servers );
        pool.setFailover( true );//故障转移
        pool.setInitConn( 10 ); //初始化连接为10
        pool.setMinConn( 5 );//最小连接为5
        pool.setMaxConn( 250 );//最大连接为250
        pool.setMaintSleep( 30 );//平衡线程休眠时间为30ms
        pool.setNagle( false );//Nagle标志为false
        pool.setSocketTO( 3000 );//响应超时时间为3000ms
        pool.setAliveCheck( true );//需要可用状态检查
        //初始化连接池，默认名称为"default"
        pool.initialize();

        //新建一个memcached客户端，如果没有给名字
        MemCachedClient mcc  = new MemCachedClient();

        UserCustom userCustom = new UserCustom();
        userCustom.setId(35);
        userCustom.setQq(32132);
        userCustom.setUsername("哈哈");
        System.out.println(userCustom);
        mcc.set("user", userCustom);
        Object cc = mcc.get("user");
        System.out.println(cc);



        /*MemcacheUtils.set("test1","124");

        String test1 = MemcacheUtils.get("testkey").toString();

        System.out.println("test1 : " + test1);*/
    }
}
