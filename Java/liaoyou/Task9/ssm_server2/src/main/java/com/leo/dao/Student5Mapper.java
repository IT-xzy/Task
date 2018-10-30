package com.leo.dao;

import com.leo.model.Student5DO;

import java.util.List;

public interface Student5Mapper {
	
	int insert(Student5DO record);
	
	Student5DO selectByPrimaryKey(Long id);
	
	Student5DO selectByName(String name);
	
	Student5DO selectByPhone(String phone);
	
	Student5DO selectByEmail(String email);
	
	List<Student5DO> selectAll();
	
	int deleteById(Long id);
	
	int updateByPrimaryKey(Student5DO record);
}
