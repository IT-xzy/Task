package com.leo.dao.impl;

import com.leo.dao.StudentDao;
import com.leo.pojo.Student;
import com.sun.org.apache.bcel.internal.util.ClassPath;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

public class StudentDaoImplTest {
	
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	StudentDao studentDao =(StudentDao) context.getBean("studentDao");
	
	@Test
	public void add() {
		Student student = new Student();
		student.setName("蓝猫");
		student.setQq(77777777);
		student.setProfession("captain");
		student.setSchool("MIT");
		student.setCreate_time(System.currentTimeMillis());
		student.setUpdate_time(System.currentTimeMillis());
		studentDao.add(student);
	}
	
	@Test
	public void findById() {
		Student student = studentDao.findById(5);
		System.out.println(student);
	}
	
	@Test
	public void update() {
		studentDao.update(21, "黑猫");
	}
	
	@Test
	public void delete() {
		studentDao.delete(21);
	}
	
	@Test
	public void findAll() {
		List<Student> students = studentDao.findAll();
		for(Student student: students){
			System.out.println(student);
		}
	}
}