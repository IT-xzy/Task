package com.jnshu.task5.test;

import redis.clients.jedis.Jedis;

public class TestRedis {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        String isJedis = jedis.ping();
        System.out.println("is Jedis success = " + isJedis);
    }
}
