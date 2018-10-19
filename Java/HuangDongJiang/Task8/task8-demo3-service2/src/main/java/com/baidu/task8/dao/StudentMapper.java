package com.baidu.task8.dao;

import com.baidu.task8.pojo.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
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
