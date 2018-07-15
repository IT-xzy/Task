package com.mvc.service;

import com.mvc.dao.Dao;
import com.mvc.model.Person;
import com.mvc.model.TypeClass;
import com.mvc.model.User;
import net.rubyeye.xmemcached.MemcachedClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class ServiceImpl implements PersonService{
	private Logger logger = LoggerFactory.getLogger(ServiceImpl.class);
	@Autowired
	Dao dao;
	@Autowired
	MemcachedClient memcachedClient;
	@Override
	public Integer queryWork(Integer isWork){
		try {
			//memcache jar包自动装载方式
			logger.info("isWork传入参数：" + isWork);
			Integer isWorks = memcachedClient.get("W" + String.valueOf(isWork));
			logger.info("接到的缓存中的value为：" + isWorks);
			if (isWorks != null) {
				logger.info("返回页面的数据为：" + isWorks.toString());
				return isWorks;
			}
			isWorks = dao.queryWork(isWork);
			logger.info("数据库中查到啦：" + isWorks);
			memcachedClient.set("W" + String.valueOf(isWork), 900, isWorks);
			return isWorks;
		}catch (Exception e){
			logger.info("错误： "+e);
		}
		return dao.queryWork(isWork);
	}
	@Override
	public List<Person> queryGood(Integer isGood){
		try {
			logger.info("isGood传入的参数是" + isGood);
			List<Person> people = memcachedClient.get("G" + String.valueOf(isGood));
			if (people != null) {
				logger.info("从缓存取出并返回的数据为：" + people.toString());
				return people;
			}
			people = dao.queryGood(isGood);
			logger.info("数据库取出的数据为" + people.toString());
			memcachedClient.set("G" + String.valueOf(isGood), 900, people);
			List<Person> person1 = memcachedClient.get("G" + String.valueOf(isGood));
			logger.info("存入缓存的数据为：" + person1.toString());
			return people;
		}catch (Exception e){
			logger.info("错误"+e);
		}
		return dao.queryGood(isGood);
	}
	@Override
	public List<TypeClass> queryDirection (String direction){
		return dao.queryDirection(direction);
	}
	@Override
	public int queryType(String type){
		return dao.queryType(type);
	}
	@Override
	public Person findStudentId(Integer ID){
		try {
			Person person = memcachedClient.get("person:" + String.valueOf(ID));
			logger.info("这是缓存中取出的结果:" + person);
			if (person != null) {
				logger.info("返回页面的缓存结果为：" + person.toString());
				return person;
			}
			person = dao.findStudentId(ID);
			logger.info("数据库中查到的结果student= ： " + person.toString());
			memcachedClient.set("person:" + String.valueOf(ID), 900, person);
			return person;
		}catch (Exception e){
			logger.info("错误："+e);
		}
		return dao.findStudentId(ID);
	}
	/*@Override
	public User queryUser(String userName) throws Exception {
		try {
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
		}
		return dao.queryUser(userName);
	}*/
	@Override
	public boolean addUser(User user){
		return dao.addUser(user);
	}
}