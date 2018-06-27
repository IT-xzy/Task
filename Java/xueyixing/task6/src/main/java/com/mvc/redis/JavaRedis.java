package com.mvc.redis;

import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class JavaRedis {
	public static void main(String[] args) throws Exception{
		//连接本地redis服务
		/*Jedis jedis = new Jedis("localhost");
		System.out.println("连接成功");

		//查看服务是否允许
		System.out.println("服务正在允许: " + jedis.ping());*/

		//设置 redis 字符串数据
		JavaRedis.setRedis("rain","王五赵六");

		//获取存储的数据并输出
		String rain1 = JavaRedis.getRedis("rain");
		System.out.println(rain1);

		//Redis Java List(列表) 实例
		//存储数据到列表中
		/*jedis.lpush("site-list", "RunOob");
		jedis.lpush("site-list", "Google");
		jedis.lpush("site-list", "TaoBao");
		jedis.lpush("site-list", "BaiDu");

		//获取存储的数据并输出
		List<String> list = jedis.lrange("site-list",0,9);
		for(int i=0;i<list.size();i++){
			System.out.println("列表项为："+list.get(i));
		}

		// 获取数据并输出
		Set<String> keys = jedis.keys("*");
		Iterator<String> it=keys.iterator() ;
		while(it.hasNext()){
			String key = it.next();
			System.out.println(key);
		}*/
	}
	public static void setRedis(String key,String value)throws Exception{
		//连接本地redis服务
		Jedis jedis = new Jedis("localhost");

		//设置 redis 字符串数据
		jedis.set(key, value);
	}
	public static String getRedis(String key)throws Exception{
		//连接本地redis服务
		Jedis jedis = new Jedis("localhost");
		System.out.println(key);
		return jedis.get(key);
	}
}
