package com.leo.service;

import com.leo.model.Student5DO;
import com.leo.model.Student5VO;

import java.util.List;

/**
 * @Belong: task5
 * @Description: 用以注册登录，主要是操作数据表
 * @Author: jk-leo
 * @Date: 2018/9/12 16:36
 */
public interface Student5Service {

	public void insert(Student5VO student5VO);
	
	Student5VO selectById(Long id);
	
	public Student5VO selectByName(String username);
	
	Student5VO selectByPhone(String phone);
	
	Student5VO selectByEmail(String email);
	
	public List<Student5DO> selectAll();
	
	public void deleteById(Long id);
	
	void updateById(Student5VO student5VO);
}
