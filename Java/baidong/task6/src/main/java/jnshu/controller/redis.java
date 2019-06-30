package jnshu.controller;

import org.apache.log4j.Logger;
import redis.clients.jedis.Jedis;

public class redis {

    public static void main(String[] args) {
//连接本机的redis服务
   Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
   //给redis插入一条数据
   jedis.set("a","11111111");
        System.out.println("插入的数据是=========="+jedis.get("a"));
}
}
