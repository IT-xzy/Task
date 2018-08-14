package com.leo;

import com.leo.mapper.StudentMapper;
import com.leo.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
	String resource = "mybatis-config.xml";
	InputStream inputStream;
	StudentMapper mapper;
	SqlSession sqlSession;
	
	{
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = sqlSessionFactory.openSession();
			mapper = sqlSession.getMapper(StudentMapper.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAdd(){
		Student student = new Student();
		student.setName("花栗鼠大王");
		student.setQq(123456);
		student.setProfession("c位");
		student.setSchool("SING");
		// 添加时间戳：在MySQL命令行中可用unix_timestamp(now()),在Java代码中可用System.currentTimeMillis();
		student.setCreate_time(System.currentTimeMillis());
		student.setUpdate_time(System.currentTimeMillis());
		mapper.add(student);
		sqlSession.commit();
		sqlSession.close();
		System.out.println("添加学生信息完毕");
	}
	
	@Test
	public void testDelete(){
		mapper.delete(19);
		sqlSession.commit();
		sqlSession.close();
	}
	
	// 更新用的SQL语句是update，它有set关键字，所以可以只更新想更新的值，其他值是不会变的
	@Test
	public void testUpdate(){
		Student student = new Student();
		student.setName("菲菲");
		student.setUpdate_time(System.currentTimeMillis());
		student.setId(18);
		mapper.update(student);
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void testGetStudent(){
		Student student = mapper.getStudent(18);
		System.out.println(student.getId()+" "+student.getName()+" "+student.getSchool());
		sqlSession.close();
	}
	
	@Test
	public void testList(){
		List<Student> students = mapper.list();
		for(Student student: students){
			System.out.println(student.getId()+" "+student.getName()+" "+student.getProfession());
		}
		sqlSession.close();
	}
	
}
