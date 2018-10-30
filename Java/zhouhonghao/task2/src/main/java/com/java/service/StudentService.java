package com.java.service;

import java.util.List;

import com.java.pojo.Student;

public interface StudentService {
	void add(Student student); 

	void delete(int id);

	Student get(int id);

	void update(Student student);

	List<Student> list();
}
