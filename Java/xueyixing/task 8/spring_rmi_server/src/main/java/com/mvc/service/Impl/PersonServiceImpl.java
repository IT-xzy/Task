package com.mvc.service.Impl;

import com.mvc.dao.PersonDao;
import com.mvc.model.Person;
import com.mvc.service.PersonService;
import net.rubyeye.xmemcached.MemcachedClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
	private Logger logger = LoggerFactory.getLogger(PersonServiceImpl.class);
	@Autowired
	PersonDao dao;
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
	public int queryType(String type){
		try {
			Integer typeNumb = memcachedClient.get(type);
			if (typeNumb != null){
				return  typeNumb;
			}
			typeNumb=dao.queryType(type);
			memcachedClient.set(type, 900, typeNumb);
			return  typeNumb;
		}catch (Exception e){
			logger.info("错误："+e.toString());
		}
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
}