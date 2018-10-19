package com.leo.service;

import com.leo.model.Student4;

import java.util.List;

public interface Student4Service {
	
	public void deleteById(Long id);
	
	public void insert(Student4 student4);
	
	public Student4 selectById(Long id);
	
	public List<Student4> selectAll();
	
	public void updateById(Student4 student4);
	
	public List<Student4> selectExcellentStudent();
	
	public int total();
	
	int isWork();
	
	// job:html,java,python,js,ios,andriod
	int jobCount(String job);
}
