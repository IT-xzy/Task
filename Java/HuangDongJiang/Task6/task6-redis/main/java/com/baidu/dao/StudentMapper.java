package com.baidu.dao;

import com.baidu.pojo.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("studentMapper")
public interface StudentMapper {
	//增
	void saveStudent(Student student);
	//根据ID删
	void deleteStudentById(Integer id);
	//改
	void updateStudent(Student student);
	//查
	Student findStudentById(Integer id);
	//查找所有学生
	List<Student> findAllStudent();
}
