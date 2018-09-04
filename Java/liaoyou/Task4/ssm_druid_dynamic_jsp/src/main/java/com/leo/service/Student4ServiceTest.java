package com.leo.service;

import com.leo.model.Student4;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Student4ServiceTest {
	
	@Autowired
	Student4Service student4Service;
	
	@Test
	public void deleteById() {
	}
	
	@Test
	public void insert() {
		Student4 student4 = new Student4();
		student4.setName("小刘");
		student4.setIntroduction("leo技术总监：互联网基础服务领域，从事虚拟主机，云主机，域名。 曾任新网高级技术经理，负责技术研发，团队管理与建设。");
		student4.setPicture("");
		student4.setJob("ios");
		student4.setIsWork(false);
		student4.setIsExcellent(false);
		System.out.println(student4Service);
		student4Service.insert(student4);
		System.out.println("insert ok");
	}
	
	@Test
	public void selectById() {
	}
	
	@Test
	public void selectAll() {
		List<Student4> student4s = student4Service.selectExcellentStudent();
		System.out.println(student4s);
	}
	
	@Test
	public void updateById() {
	}
	
	@Test
	public void count(){
		int total = student4Service.isWork();
		System.out.println(total);
	}
	
	@Test
	public void jobCount(){
		int job = student4Service.jobCount("js");
		System.out.println(job);
	}
}