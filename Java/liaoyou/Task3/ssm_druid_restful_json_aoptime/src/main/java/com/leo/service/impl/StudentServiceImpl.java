package com.leo.service.impl;

import com.leo.mapper.StudentMapper;
import com.leo.pojo.Student;
import com.leo.service.StudentService;
import com.leo.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	StudentMapper studentMapper;
	
	@Override
	public void add(Student student) {
		student.setCreate_time(System.currentTimeMillis());
		student.setUpdate_time(System.currentTimeMillis());
		studentMapper.add(student);
	}

	@Override
	public void delete(long id) {
		studentMapper.delete(id);
	}

	@Override
	public Student get(long id) {
		return studentMapper.get(id);
	}

	@Override
	public void update(Student student) {
		student.setUpdate_time(System.currentTimeMillis());
		studentMapper.update(student);
	}
	
	@Override
	public List<Student> list() {
		return studentMapper.list();
	}
	
	@Override
	public List<Student> list(Page page) {
		return studentMapper.list(page);
	}
	
	@Override
	public int total() {
		return studentMapper.total();
	}
}
