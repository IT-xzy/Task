package com.leo.mapper;

import com.leo.pojo.Student;
import com.leo.utils.Page;

import java.util.List;

public interface StudentMapper {
	
	public int add(Student student);
	// delete()返回值为in
	public int delete(long id);
	public Student get(long id);
	public int update(Student student);
	public List<Student> list();
	public List<Student> list(Page page);
	public int total();
}
