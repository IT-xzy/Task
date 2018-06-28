package com.mvc.service;

import com.mvc.dao.Dao;
import com.mvc.memcached.JavaMemcached;
import com.mvc.model.Team;
import com.mvc.model.TypeClass;
import com.mvc.model.Student;
import com.mvc.model.User;
import com.mvc.redis.JavaRedis;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.List;
import java.util.concurrent.TimeoutException;

public class ServiceImpl implements PersonService{
	private Logger logger = LoggerFactory.getLogger(ServiceImpl.class);
	@Autowired
	Dao dao;
	/*@Autowired
	MemcachedClient memcachedClient;*/
	@Autowired
	JavaRedis javaRedis;
	@Autowired
	RedisTemplate redisTemplate;
	@Override
	public Integer queryWork(Integer isWork) throws Exception {
		//redis jar包自动装载方式
		ValueOperations<String, String> stringOperations = redisTemplate.opsForValue();
		String isWorks = stringOperations.get(String.valueOf(isWork));
		if (isWorks!=null){
			return Integer.parseInt(isWorks);
		}
		Integer isWork1 = dao.queryWork(isWork);
		stringOperations.setIfAbsent(String.valueOf(isWork), String.valueOf(isWork1));

		//redis 自动装载封装类
		/*String isWorks = javaRedis.getRedis(String.valueOf(isWork));
		if (isWorks!=null){
			return Integer.parseInt(isWorks);
		}
		Integer isWork1 = dao.queryWork(isWork);
		javaRedis.setRedis(String.valueOf(isWork),String.valueOf(isWork1));*/

		//memcache jar包自动装载方式
		/*logger.info("isWork传入参数" + isWork)
		Integer isWorks = memcachedClient.get(String.valueOf(isWork));
		logger.info("接到参数" + isWorks);
		if (isWorks!=null){
			return isWorks;
		}
		isWorks = dao.queryWork(isWork);
		memcachedClient.set(String.valueOf(isWork),900,isWorks);
		return isWorks;*/
		return isWork1;
	}
	@Override
	public List<Student> queryGood(Integer isGood) throws InterruptedException, MemcachedException, TimeoutException {
		/*logger.info("isGood传入的参数是" + isGood);
		List<Student> students = memcachedClient.get("5"+String.valueOf(isGood));
		if (students!=null){
			return students;
		}
		students = dao.queryGood(isGood);
		logger.info(students.toString());
		memcachedClient.set("5"+String.valueOf(isGood),900,students);
		List<Student> student1 = memcachedClient.get("5"+String.valueOf(isGood));
		logger.info(student1.toString()+"11111111111111111111111111111111111");
		return students;*/
		return dao.queryGood(isGood);
	}
	/*@Override
	public Student queryGood(int isGood){
		return dao.queryGood(isGood);
	}*/
	/*@Override
	public TypeClass queryDirection(String direction){
		return dao.queryDirection(direction);
	}*/
	@Override
	public List<TypeClass> queryDirection (String direction){
		return dao.queryDirection(direction);
	}
	@Override
	public int queryType(String type){
		return dao.queryType(type);
	}
	/*@Override
	public User queryUser(String userName) throws Exception {
		*//*User user = (User) JavaMemcached.getMemcached(userName);

		logger.debug(userName+"sssssssssssssssssssssssssss");

		if (user!=null){
			logger.debug(user.toString());
			return user;
		}
		user = dao.queryUser(userName);
		logger.debug(user.toString());
		JavaMemcached.setMem(userName,user);
		return user;*//*
		return dao.queryUser(userName);
	}*/
	@Override
	public User queryUser(String userName) throws Exception {
/*		try {
			User user = memcachedClient.get(userName);
			if (user!=null){
				return user;
			}
			user = dao.queryUser(userName);
			memcachedClient.set(userName,900,user);
			return user;
		} catch (TimeoutException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (MemcachedException e) {
			e.printStackTrace();
		}*/
		return dao.queryUser(userName);
	}
	@Override
	public boolean addUser(User user){
		return dao.addUser(user);
	}
	@Override
	public User queryID(String a){
		return dao.queryID(a);
	}
}
