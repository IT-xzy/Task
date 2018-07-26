package com.leo.mapper;

import com.leo.pojo.Student;

import java.util.List;

public interface StudentMapper {
	public int add(Student student);
	public void delete(int id);
	public Student get(int id);
	public int update(Student student);
	public List<Student> list();
}
