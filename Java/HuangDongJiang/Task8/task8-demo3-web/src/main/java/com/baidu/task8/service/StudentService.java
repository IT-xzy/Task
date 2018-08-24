package com.baidu.task8.service;

import com.baidu.task8.pojo.Student;

import java.util.List;

public interface StudentService {
	/**
	 * 添加学生信息
	 * @param student
	 */
	void saveStudent(Student student);
	/**
	 * 删除学生信息
	 * @param id
	 */
	void deleteStudentById(int id);
	//更改学生信息

	/**
	 * @param student
	 * 更改学生信息
	 */
	void updateStudent(Student student);
	/**
	 * 查找学生信息
	 * @param id
	 * @return Student
	 */
	Student findStudentById(int id);

	/**
	 * 查找所有的学生
	 * @return
	 */
	List<Student> findAllStudent();
}
