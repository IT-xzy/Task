package com.leo.service.impl;

import com.leo.dao.Student5Mapper;
import com.leo.model.Student5DO;
import com.leo.model.Student5VO;
import com.leo.service.Login5Service;
import com.leo.service.Student5Service;
import com.leo.utils.DESUtil;
import com.leo.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Login5ServiceImpl implements Login5Service {
	
	@Autowired
	Student5Mapper student5Mapper;
	@Autowired
	Student5Service student5Service;
	
	@Override
	public Long validate(Student5VO student5VO) {
		Student5DO student5DO = student5Mapper.selectByName(student5VO.getName());
		if (student5DO == null){
			throw new NullPointerException("没有此用户记录");
		}
		String salt = student5DO.getSalt();
		String loginPwdHash = MD5Util.getPasswordHash(student5VO.getPassword(),salt);
		boolean var = student5DO.getPassword_hash().equals(loginPwdHash);
		if (var == true){
			return student5DO.getId();
		} else {
			return null;
		}
	}
	
	@Override
	public String generatorToken(Student5VO student5VO){
		Student5VO student5VO1 = student5Service.selectByName(student5VO);
		Long loginTime = System.currentTimeMillis();
		String plaintext =student5VO1.getId().toString()+"|"+loginTime.toString();
		String ciphertext = DESUtil.encrypt(plaintext);
		return ciphertext;
	}
}
