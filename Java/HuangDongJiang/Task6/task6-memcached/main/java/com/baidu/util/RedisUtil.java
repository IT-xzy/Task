package com.baidu.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class RedisUtil {
	private JedisPool pool = null;
	/**
	 * 获取Jedis连接池
	 */
	public JedisPool getPool() {
		InputStream inputStream = RedisUtil.class.getClassLoader().getResourceAsStream("redis.properties");
		Properties properties = new Properties();
		try {
			properties.load(inputStream);
		} catch (IOException e) {
			System.out.println("................");
			e.printStackTrace();
		}
		if (pool == null) {
			//创建jedis连接池配置
			JedisPoolConfig config = new JedisPoolConfig();
			//最大空闲连接数
			config.setMaxIdle(Integer.valueOf(properties.getProperty("redis.maxIdle")));
			//最大连接数
			config.setMaxTotal(Integer.valueOf(properties.getProperty("redis.maxTotal")));
			//创建Redis连接池
			pool = new JedisPool(config, properties.getProperty("redis.host"),
					Integer.valueOf(properties.getProperty("redis.port")),
					Integer.valueOf(properties.getProperty("redis.timeOut")));
		}
		return pool;
	}
	/**
	 * 获取连接
	 */
	public  Jedis getCon(){
		return getPool().getResource();
	}
}
