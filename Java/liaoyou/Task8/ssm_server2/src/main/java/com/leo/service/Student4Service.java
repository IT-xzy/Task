package com.leo.service;

import com.leo.model.Student4;

import java.util.List;

/**
 * @Belong: task4
 * @Description: 用以提供home与job页数据
 * @Author: jk-leo
 * @Date: 2018/9/12 16:33
 */
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
