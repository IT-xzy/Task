package com.leo.utils;

import redis.clients.jedis.Jedis;

public class RedisHello {
	public static void main(String[] args){
		Jedis jedis = new Jedis("118.24.36.126",6379);
		System.out.println("连接成功");
		System.out.println("服务器正在运行："+jedis.ping());
	}
}
