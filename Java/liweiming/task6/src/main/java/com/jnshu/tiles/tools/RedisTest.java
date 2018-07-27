package com.jnshu.tiles.tools;

import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * @program: Tiles
 * @description: Java操作Redis测试
 * @author: Mr.Lee
 * @create: 2018-07-15 11:15
 **/
public class RedisTest {

    private Jedis jedis;

    @Before
    public void setJedis() {
        //连接redis服务器(在这里是连接本地的)
        jedis = new Jedis("localhost");
        System.out.println(jedis.ping());
        //权限认证
//        jedis.auth("chenhaoxiang");

        System.out.println("连接服务成功");
    }

    /**
     * Redis操作字符串
     */

    @Test
    public void testString() {

        //添加数据
        jedis.set("name", "chx"); //key为name放入value值为chx
        System.out.println("拼接前:" + jedis.get("name"));//读取key为name的值

        //向key为name的值后面加上数据 ---拼接
        jedis.append("name", " is my name;");
        System.out.println("拼接后:" + jedis.get("name"));

        //删除某个键值对
        jedis.del("name");
        System.out.println("删除后:" + jedis.get("name"));

        //s设置多个键值对
        jedis.mset("name", "chenhaoxiang", "age", "20", "email", "chxpostbox@outlook.com");
        jedis.incr("age");//用于将键的整数值递增1。如果键不存在，则在执行操作之前将其设置为0。 如果键包含错误类型的值或包含无法表示为整数的字符串，则会返回错误。此操作限于64位有符号整数。
        System.out.println(jedis.get("name") + " " + jedis.get("age") + " " + jedis.get("email"));

    }

}
