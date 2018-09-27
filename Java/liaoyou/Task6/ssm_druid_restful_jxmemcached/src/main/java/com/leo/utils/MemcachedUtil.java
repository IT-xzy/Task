package com.leo.utils;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;
import java.util.Map;
import java.util.concurrent.TimeoutException;

@Component
public class MemcachedUtil {
	
	private static final Logger logger = LogManager.getLogger("mylog");
	
	@Autowired
	MemcachedClient memcachedClient;
	
	// 设置最长等待时间20秒
	private static Long opTimeout = 20000L;
	// 设置缓存过期时间3小时
	private static final int expire = 60*60*3;
	
	// 判断memcached是否可用
	public boolean isAvaliable(){
		if (memcachedClient.isShutdown()){
			logger.error("memcached客户端已关闭");
			return false;
		}
		Map<InetSocketAddress,String> map = null;
		try {
			map = memcachedClient.getVersions();
		} catch (TimeoutException e) {
			logger.error("获取memcached服务端版本时超时");
		} catch (InterruptedException e) {
			logger.error("获取memcached服务端版本时异常");
		} catch (MemcachedException e) {
			logger.error("获取memcached版本时异常");
		}
		if (map==null || map.size()==0){
			logger.error("当前没有可用的memcached server");
			return false;
		}
		return true;
	}
	
	public Object getValue(String key){
		Object value = null;
		if (key != null){
			try {
				value = memcachedClient.get(key);
			} catch (TimeoutException e) {
				logger.error("Cache TimeoutException", e);
			} catch (InterruptedException e) {
				logger.error("Cache InterruptedException", e);
			} catch (MemcachedException e) {
				logger.error("Cache MemcachedException", e);
			}
		} else {
			logger.error("key is null");
			return null;
		}
		return value;
	}
	
	public <T> T getValue(String key, Class<T> t){
		T value = null;
		if (key != null){
			try {
				value = memcachedClient.get(key);
			} catch (TimeoutException e) {
				logger.error("Cache TimeoutException", e);
			} catch (InterruptedException e) {
				logger.error("Cache InterruptedException", e);
			} catch (MemcachedException e) {
				logger.error("Cache MemcachedException", e);
			}
		} else {
			logger.error("key is null");
			return null;
		}
		return value;
	}
	
	public void setValue(String key, Object value){
		if (key != null){
			try {
				memcachedClient.set(key,expire,value);
			} catch (TimeoutException e) {
				logger.error("Cache TimeoutException", e);
			} catch (InterruptedException e) {
				logger.error("Cache InterruptedException", e);
			} catch (MemcachedException e) {
				logger.error("Cache MemcachedException", e);
			}
		} else {
			logger.error("key is null");
		}
	}
	
	public void setValue(String key, int expire, Object value){
		if (key != null && expire > 0){
			try {
				memcachedClient.set(key,expire,value);
			} catch (TimeoutException e) {
				logger.error("Cache TimeoutException", e);
			} catch (InterruptedException e) {
				logger.error("Cache InterruptedException", e);
			} catch (MemcachedException e) {
				logger.error("Cache MemcachedException", e);
			}
		} else {
			logger.error("输入的key,expire有误！");
		}
	}
	
	public boolean delete(String key){
		try {
			return memcachedClient.delete(key,opTimeout);
		} catch (TimeoutException e) {
			logger.error("Cache TimeoutException", e);
		} catch (InterruptedException e) {
			logger.error("Cache InterruptedException", e);
		} catch (MemcachedException e) {
			logger.error("Cache MemcachedException", e);
		}
		
		return false;
	}
	
	public boolean delete(String key, Long newOpTimeout){
		try {
			return memcachedClient.delete(key,newOpTimeout);
		} catch (TimeoutException e) {
			logger.error("Cache TimeoutException", e);
		} catch (InterruptedException e) {
			logger.error("Cache InterruptedException", e);
		} catch (MemcachedException e) {
			logger.error("Cache MemcachedException", e);
		}
		return false;
	}
	
	public MemcachedClient getMemcachedClient(){
		return memcachedClient;
	}
}
