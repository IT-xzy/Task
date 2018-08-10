package com.leo.service;

import com.leo.pojo.Student;
import com.leo.util.Page;

import java.util.List;

public interface StudentService {
	
	public void add(Student student);
	
	public void delete(long id);
	
	public Student get(long id);
	
	public void update(Student student);
	
	public List<Student> list();
	
	public List<Student> list(Page page);
	
	public int total();
}
