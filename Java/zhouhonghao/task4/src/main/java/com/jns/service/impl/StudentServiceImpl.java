package com.jns.service.impl;

import com.jns.mapper.StudentMapper;
import com.jns.pojo.Student;
import com.jns.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
	/**
	 *
	 */
	@Autowired
	private StudentMapper studentMapper;
	@Override
	public void add(Student student) {
		// TODO 自动生成的方法存根
		studentMapper.add(student);
	}

	@Override
	public void delete(int id) {
		// TODO 自动生成的方法存根
		studentMapper.delete(id);
	}

	@Override
	public Student get(int id) {
		// TODO 自动生成的方法存根
		return studentMapper.get(id);
	}

	@Override
	public void update(Student student) {
		// TODO 自动生成的方法存根
		studentMapper.update(student);
	}

	@Override
	public List<Student> list() {
		// TODO 自动生成的方法存根
		return studentMapper.list();
	}

}
