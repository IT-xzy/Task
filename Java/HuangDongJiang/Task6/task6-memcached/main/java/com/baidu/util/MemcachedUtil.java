package com.baidu.util;

import net.rubyeye.xmemcached.MemcachedClient;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemcachedUtil {
	public static MemcachedClient getMemcachedClient() {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"classpath:spring/memcachedContext.xml");
		MemcachedClient memcachedClient = (MemcachedClient)applicationContext.getBean("memcachedClient");
		return memcachedClient;
	}
}
