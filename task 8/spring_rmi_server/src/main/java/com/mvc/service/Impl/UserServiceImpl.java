package com.mvc.service.Impl;

import com.mvc.dao.UserDao;
import com.mvc.model.User;
import com.mvc.service.UserService;
import net.rubyeye.xmemcached.MemcachedClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	UserDao dao;
	@Autowired
	MemcachedClient memcachedClient;

	@Override
	public boolean addUser(User user){
		return dao.addUser(user);
	}

}