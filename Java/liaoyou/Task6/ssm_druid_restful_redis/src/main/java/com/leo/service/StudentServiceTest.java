package com.leo.service;

import com.leo.pojo.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Belong:
 * @Description:
 * @Author: jk-leo
 * @Date: 2018/9/8 22:47
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class StudentServiceTest {
	
	@Autowired
	StudentService studentService;
	
	@Test
	public void list() {
		List<Student> students = studentService.list();
		System.out.println(students);
	}
}