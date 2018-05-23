package com.ptteng.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ResourceBundle;

public class redisDeprecated {
    //使用redis连接池
    public Jedis getJedis(){
        //添加commons-pool.jar,后配置redis.properties属性文件
        //加载配置文件
        ResourceBundle bundle = ResourceBundle.getBundle("redis");
        //创建配置对象
        JedisPoolConfig config = new JedisPoolConfig();
        String host = bundle.getString("redis.host");
        String port = bundle.getString("redis.port");

        config.setMaxIdle(Integer.parseInt(bundle.getString("redis.pool.maxIdle")));
        config.setTestOnBorrow(Boolean.parseBoolean(bundle.getString("redis.pool.testOnBorrow")));

        //创建Jedis连接池
        JedisPool pool = new JedisPool(config,host);
        //通过连接池,获取Jedis
        Jedis jedis = pool.getResource();
        jedis.shutdown();

        //JedisPool的returnResource()方法,在jedis3.0将会被废除.关闭Jedis应该用Jedis.close();进行资源回收
//        pool.returnResource(jedis);
        jedis.close();
        return  jedis;
    }

}
