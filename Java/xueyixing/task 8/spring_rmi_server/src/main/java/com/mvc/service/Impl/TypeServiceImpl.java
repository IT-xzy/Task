package com.mvc.service.Impl;

import com.mvc.dao.TypeDao;
import com.mvc.model.Type;
import com.mvc.service.TypeService;
import net.rubyeye.xmemcached.MemcachedClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

	private Logger logger = LoggerFactory.getLogger(TypeServiceImpl.class);
	@Autowired
	TypeDao dao;
	@Autowired
	MemcachedClient memcachedClient;

	@Override
	public List<Type> queryDirection (String direction){
		try{
			List<Type> type = memcachedClient.get(direction);
			if (type!=null){
				return type;
			}
			type = dao.queryDirection(direction);
			memcachedClient.set(direction,90000,type);
		}catch (Exception e){
			logger.info(e.toString());
		}
		return dao.queryDirection(direction);
	}
}