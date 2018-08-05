package com.tool;

import com.pojo.User;
import redis.clients.jedis.Jedis;

import java.util.List;

public class myRedis {
    public static void main(String[] args) {
        //连接本地的 Redis 服务，Jedis操作Redis的类
        Jedis jedis = new Jedis("localhost");

        System.out.println("连接成功");

        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());

        //设置 redis 字符串数据
        jedis.set("runoobkey", "www.runoob.com");

         //获取存储的数据并输出
        System.out.println("redis 存储的字符串为: "+ jedis.get("runoobkey"));


        //存储数据到列表中
        jedis.lpush("site-list", "Runoob");
        jedis.lpush("site-list", "Google");
        jedis.lpush("site-list", "Taobao");
        // 获取存储的数据并输出
        List<String> list = jedis.lrange("site-list", 0 ,2);
        for (String aList : list) {
            System.out.println("列表项为: " + aList);
        }

        RedisUtils.addObject("key1",new User());
        System.out.println(RedisUtils.getObject("key1",User.class));
    }
}
