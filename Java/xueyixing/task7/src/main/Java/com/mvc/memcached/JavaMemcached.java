package com.mvc.memcached;

import net.spy.memcached.MemcachedClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Future;

public class JavaMemcached {

	private static Logger logger = LoggerFactory.getLogger(JavaMemcached.class);

	public static void setMem(String key, Object value) throws Exception {

		logger.info("方法被调用了");

		// 连接本地的 Memcached 服务
		MemcachedClient mcc = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));

		logger.info("连接本地服务");
		logger.info(key + "ssss");
		logger.info(value.toString());

		// 添加数据
		Future fo = mcc.set(key, 900, value);

		// 输出执行 set 方法后的状态
		logger.info("添加数据状态：" + fo.get());

		// 关闭连接
		mcc.shutdown();
	}

	public static Object getMemcached(String key){

		// 连接本地的 Memcached 服务
		MemcachedClient mcc = null;
		try {
			mcc = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));

			// 使用 get 方法获取数据
			Object sh = mcc.get(key);

			// 关闭连接
			mcc.shutdown();
			return sh;

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
