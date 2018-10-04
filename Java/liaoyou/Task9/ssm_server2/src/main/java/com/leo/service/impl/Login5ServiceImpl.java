package com.leo.service.impl;

import com.leo.dao.Student5Mapper;
import com.leo.model.Student5DO;
import com.leo.model.Student5VO;
import com.leo.service.Login5Service;
import com.leo.service.Student5Service;
import com.leo.utils.DESUtil;
import com.leo.utils.MD5Util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.cache.Cache;
import javax.cache.CacheManager;

@Service
public class Login5ServiceImpl implements Login5Service {
	
	@Autowired
	Student5Mapper student5Mapper;
	@Autowired
	Student5Service student5Service;
	@Autowired
//	CacheManager cacheManager;
	
	private static Logger logger = (Logger) LogManager.getLogger("mylog");
	
	@Override
	public Long validate(Student5VO student5VO) {
		Student5DO student5DO = null;
		if (student5VO.getName() != null){
			student5DO = student5Mapper.selectByName(student5VO.getName());
		} else if (student5VO.getPhone() != null){
			student5DO = student5Mapper.selectByPhone(student5VO.getPhone());
			logger.debug("通过手机号获得用户信息:"+student5DO);
		} else if (student5VO.getEmail() != null){
			student5DO = student5Mapper.selectByEmail(student5VO.getEmail());
		}
		if (student5DO == null){
			throw new NullPointerException("没有此用户记录");
		}
		String salt = student5DO.getSalt();
		String loginPwdHash = MD5Util.getPasswordHash(student5VO.getPassword(),salt);
		boolean var = student5DO.getPassword_hash().equals(loginPwdHash);
		logger.info("数据库验证结果:"+var);
		if (var == true){
			return student5DO.getId();
		} else {
			return null;
		}
	}
	
	@Override
	public String generatorToken(Student5VO student5VO){
		Student5VO student5VO1 = null ;
		if (student5VO.getName() != null){
			student5VO1 = student5Service.selectByName(student5VO.getName());
		} else if (student5VO.getPhone() != null){
			student5VO1 = student5Service.selectByPhone(student5VO.getPhone());
		} else if (student5VO.getEmail() != null){
			student5VO1 = student5Service.selectByEmail(student5VO.getEmail());
		}
		
		Long loginTime = System.currentTimeMillis();
		String plaintext =student5VO1.getId().toString()+"|"+loginTime.toString();
		String ciphertext = DESUtil.encrypt(plaintext);
		return ciphertext;
	}
	
/*	@Override
	public Boolean validateCode(String key, String code){
		Cache<String,String> myCache = cacheManager.getCache("myCache");
		logger.debug("表单传入的验证码："+code);
		String value = myCache.get(key);
		logger.debug("缓存中的验证码："+value);
		if (code.equals(value)){
			return true;
		} else {
			return false;
		}
	}*/
}
