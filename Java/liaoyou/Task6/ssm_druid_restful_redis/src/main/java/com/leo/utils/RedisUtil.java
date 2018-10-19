package com.leo.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Belong: task6
 * @Description: redis工具类
 * @Author: jk-leo
 * @Date: 2018/9/8 19:18
 */
@Component
public class RedisUtil {
	
	Logger logger = LogManager.getLogger("mylog");
	
	@Autowired
	private RedisTemplate<Object,Object> redisTemplate;
	
	// 设置缓存过期时间3小时
	private static final int expire = 60*60*3;
	
	public RedisTemplate<Object,Object> getRedisTemplate(){
		return redisTemplate;
	}
	
	/**
	 * @Desciption: 设置缓存失效时间
	 * @Param: key
	 * @Return: void
	 * @Author: jk-leo
	 * @Date: 2018/9/8 20:43
	 */
	public void setExpire(String key){
		redisTemplate.expire(key,expire,TimeUnit.SECONDS);
	}
	
	/**
	 * @Desciption: 存储字符串类型数据
	 * @Param: [String key, Object value]
	 * @Return: void
	 * @Author: jk-leo
	 * @Date: 2018/9/8 20:17
	 */
	public void setStringValue(String key, String value){
		redisTemplate.opsForValue().set(key,value,expire,TimeUnit.SECONDS);
	}
	
	/**
	 * @Desciption: 获取字符串
	 * @Param: key
	 * @Return: String
	 * @Author: jk-leo
	 * @Date: 2018/9/8 21:07
	 */
	public String getStringValue(String key){
		return key==null ? null : (String) redisTemplate.opsForValue().get(key);
	}
	
	public void deleteStringValue(String key){
		redisTemplate.opsForValue().getOperations().delete(key);
	}
	
	/**
	 * @Desciption: 向指定hash表中放入数据，如果不存在将创建
	 * @Param: key,hashKey,value
	 * @Return: void
	 * @Author: jk-leo
	 * @Date: 2018/9/8 20:48
	 */
	public void setHashValue(String key,String hashKey, Object value){
		redisTemplate.opsForHash().put(key,hashKey,value);
		setExpire(key);
	}
	
	/**
	 * @Desciption: 获取指定hash表中的指定值
	 * @Param: key,hashKey
	 * @Return: Object
	 * @Author: jk-leo
	 * @Date: 2018/9/8 21:09
	 */
	public Object getHashValue(String key,Object hasKey){
		return redisTemplate.opsForHash().get(key,hasKey);
	}
	
	/**
	 * @Desciption: 存储一张hash table
	 * @Param: key map
	 * @Return: void
	 * @Author: jk-leo
	 * @Date: 2018/9/8 21:10
	 */
	public void setHashMapValue(String key,Map<String,Object> map){
		redisTemplate.opsForHash().putAll(key,map);
		setExpire(key);
	}
	
	/**
	 * @Desciption: 获取指定的hash表
	 * @Param: key
	 * @Return: hash table
	 * @Author: jk-leo
	 * @Date: 2018/9/8 20:34
	 */
	public Map<Object,Object> getHahMapValue(String key){
		return redisTemplate.opsForHash().entries(key);
	}
	
	/**
	 * @Desciption: 删除指定hash表中的指定值
	 * @Param: key,hashKey
	 * @Return: void
	 * @Author: jk-leo
	 * @Date: 2018/9/8 21:05
	 */
	public void deleteHashValue(String key,Object hashKey){
		redisTemplate.opsForHash().delete(key,hashKey);
	}
	
	/**
	 * @Desciption: 删除指定hash表
	 * @Param: key
	 * @Return: void
	 * @Author: jk-leo
	 * @Date: 2018/9/8 21:06
	 */
	public void deleteHashMapValue(String key){
		redisTemplate.opsForHash().delete(key);
	}
	
	public void setListValue(String key,Object value){
		redisTemplate.opsForList().leftPush(key,value);
	}
	
	public Object getListValue(String key){
		return redisTemplate.opsForList().leftPop(key);
	}
	
	public void deleteListValue(String key){
		redisTemplate.opsForList().getOperations().delete(key);
	}
}
