package com.leo.dao;

import com.leo.pojo.Student;

import java.util.List;

public interface StudentDao {
	
	public int add(Student student);
	
	public Student findById(int id);
	
	public void update(int id, String name);
	
	public void delete(int id);
	
	public List<Student> findAll();
}
