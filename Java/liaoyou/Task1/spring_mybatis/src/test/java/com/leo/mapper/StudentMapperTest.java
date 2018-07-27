package com.leo.mapper;

import com.leo.pojo.Student;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class StudentMapperTest {
	
	Logger logger = (Logger) LogManager.getLogger("mylog");
	
	@Autowired
	private StudentMapper studentMapper;
	
	@Test
	public void add() {
		Student student = new Student();
		student.setName("颜王222");
		student.setQq(2222222);
		student.setProfession("actor");
		student.setSchool("极限男人帮");
		student.setCreate_time(System.currentTimeMillis());
		student.setUpdate_time(System.currentTimeMillis());
		studentMapper.add(student);
		logger.info("添加成功");
	}
	
	@Test
	public void delete() {
		studentMapper.delete(22);
		logger.info("删除22成功");
	}
	
	@Test
	public void get() {
		Student student = studentMapper.get(21);
		System.out.println(student);
	}
	
	@Test
	public void update() {
		Student student = new Student();
		student.setName("颜王孙");
		// 将int类型的21强转成long类型
		student.setId((long)21);
		student.setUpdate_time(System.currentTimeMillis());
		studentMapper.update(student);
	}
	
	@Test
	public void list() {
		List<Student> students = studentMapper.list();
		for(Student student: students){
			System.out.println(student);
		}
	}
}