package com.leo.dao;

import com.leo.model.Student5DO;

public interface Student5Mapper {
	
	int insert(Student5DO record);
	
	Student5DO selectByPrimaryKey(Long id);
	
	Student5DO selectByName(String name);
}
