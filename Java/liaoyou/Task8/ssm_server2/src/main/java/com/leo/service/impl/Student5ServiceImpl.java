package com.leo.service.impl;

import com.leo.dao.Student5Mapper;
import com.leo.model.Student5VO;
import com.leo.model.Student5DO;
import com.leo.service.Student5Service;
import com.leo.utils.MD5Util;
import com.leo.utils.Salt;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Student5ServiceImpl implements Student5Service {
	
	private static Logger logger = (Logger) LogManager.getLogger("mylog");
	
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
		student5DO.setPhone(student5VO.getPhone());
		student5DO.setEmail(student5VO.getEmail());
		student5Mapper.insert(student5DO);
		logger.info("成功添加到数据库");
	}
	
	@Override
	public Student5VO selectById(Long id){
		Student5DO student5DO = student5Mapper.selectByPrimaryKey(id);
		if (student5DO == null){
			System.out.println("无此ID");
			return null;
		}
		Student5VO student5VO1 = new Student5VO();
		student5VO1.setId(student5DO.getId());
		student5VO1.setName(student5DO.getName());
		student5VO1.setCreate_at(student5DO.getCreate_at());
		student5VO1.setUpdate_at(student5DO.getUpdate_at());
		student5VO1.setPhone(student5DO.getPhone());
		student5VO1.setImage(student5DO.getImage());
		student5VO1.setEmail(student5DO.getEmail());
		logger.info("查询记录的ID为："+id);
		return student5VO1;
	}
	
	@Override
	public Student5VO selectByName(String username){
		Student5DO student5DO = student5Mapper.selectByName(username);
		if (student5DO == null){
			System.out.println("无此username");
			return null;
		}
		Student5VO student5VO1 = new Student5VO();
		student5VO1.setId(student5DO.getId());
		student5VO1.setName(student5DO.getName());
		student5VO1.setCreate_at(student5DO.getCreate_at());
		student5VO1.setUpdate_at(student5DO.getUpdate_at());
		student5VO1.setPhone(student5DO.getPhone());
		student5VO1.setEmail(student5DO.getEmail());
		student5VO1.setImage(student5DO.getImage());
		logger.info("查询记录的名字为："+username);
		return student5VO1;
	}
	
	@Override
	public Student5VO selectByPhone(String phone){
		Student5DO student5DO = student5Mapper.selectByPhone(phone);
		if (student5DO == null){
			System.out.println("无此phone");
			return null;
		}
		Student5VO student5VO = new Student5VO();
		student5VO.setId(student5DO.getId());
		student5VO.setName(student5DO.getName());
		student5VO.setCreate_at(student5DO.getCreate_at());
		student5VO.setUpdate_at(student5DO.getUpdate_at());
		student5VO.setPhone(student5DO.getPhone());
		student5VO.setEmail(student5DO.getEmail());
		student5VO.setImage(student5DO.getImage());
		return student5VO;
	}
	
	@Override
	public Student5VO selectByEmail(String email){
		Student5DO student5DO = student5Mapper.selectByEmail(email);
		if (student5DO == null){
			System.out.println("无此email");
			return null;
		}
		Student5VO student5VO1 = new Student5VO();
		student5VO1.setId(student5DO.getId());
		student5VO1.setName(student5DO.getName());
		student5VO1.setCreate_at(student5DO.getCreate_at());
		student5VO1.setUpdate_at(student5DO.getUpdate_at());
		student5VO1.setPhone(student5DO.getPhone());
		student5VO1.setEmail(student5DO.getEmail());
		student5VO1.setImage(student5DO.getImage());
		return student5VO1;
	}
	
	@Override
	public List<Student5DO> selectAll(){
		logger.info("已查询全部数据");
		return student5Mapper.selectAll();
	}
	
	@Override
	public void deleteById(Long id){
		logger.info("已删除数据的ID为："+id);
		student5Mapper.deleteById(id);
	}
	
	@Override
	public void updateById(Student5VO student5VO){
		Student5DO student5DO = new Student5DO();
		student5DO.setId(student5VO.getId());
		student5DO.setName(student5VO.getName());
		student5DO.setPhone(student5VO.getPhone());
		student5DO.setEmail(student5VO.getEmail());
		student5DO.setUpdate_at(System.currentTimeMillis());
		student5DO.setImage(student5VO.getImage());
		System.out.println(student5DO);
		int flag = student5Mapper.updateByPrimaryKey(student5DO);
		System.out.println("service更新标识："+flag);
	}
}
