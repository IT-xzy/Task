package com.baidu.service;

import com.baidu.pojo.Student;
import net.rubyeye.xmemcached.exception.MemcachedException;

import java.util.List;
import java.util.concurrent.TimeoutException;

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
	void deleteStudentById(int id) throws Exception;
	//更改学生信息

	/**
	 * @param student
	 * 更改学生信息
	 */
	void updateStudent(Student student) throws Exception;
	/**
	 * 查找学生信息
	 * @param id
	 * @return Student
	 */
	Student findStudentById(int id) throws Exception;

	/**
	 * 查找所有的学生
	 * @return
	 */
	List<Student> findAllStudent() throws InterruptedException, MemcachedException, TimeoutException;
}
