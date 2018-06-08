package com.ptteng.util;

import redis.clients.jedis.Jedis;

public class RedisUtil {
    //新建Jedis客户端连接redis服务
    private static Jedis jedis = new Jedis("localhost");

    //普通数据可以用jedis直接去存储数据，比较复杂的数据比如List会用到序列化和反序列化方法。
    //序列化方法
//    public byte[] serialized
    //反序列化方法
}
