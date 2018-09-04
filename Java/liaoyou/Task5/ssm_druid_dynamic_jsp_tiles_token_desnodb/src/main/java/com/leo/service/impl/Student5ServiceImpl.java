package com.leo.service.impl;

import com.leo.dao.Student5Mapper;
import com.leo.model.Student5VO;
import com.leo.model.Student5DO;
import com.leo.service.Student5Service;
import com.leo.utils.MD5Util;
import com.leo.utils.Salt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Student5ServiceImpl implements Student5Service {
	
	@Autowired
	Student5Mapper student5Mapper;
	
	@Override
	public void insert(Student5VO student5VO) {
		String salt = Salt.getSalt();
		String pwdHash = MD5Util.getPasswordHash(student5VO.getPassword(),salt);
		
		Student5DO student5DO = new Student5DO();
		student5DO.setName(student5VO.getName());
		student5DO.setPassword_hash(pwdHash);
		student5DO.setSalt(salt);
		student5DO.setCreate_at(System.currentTimeMillis());
		student5DO.setUpdate_at(System.currentTimeMillis());
		student5Mapper.insert(student5DO);
	}
	
	@Override
	public Student5VO selectByName(Student5VO student5VO){
		Student5DO student5DO = student5Mapper.selectByName(student5VO.getName());
		Student5VO student5VO1 = new Student5VO();
		student5VO1.setId(student5DO.getId());
		student5VO1.setName(student5DO.getName());
		student5VO1.setCreate_at(student5DO.getCreate_at());
		student5VO1.setUpdate_at(student5DO.getUpdate_at());
		return student5VO1;
	}
}
