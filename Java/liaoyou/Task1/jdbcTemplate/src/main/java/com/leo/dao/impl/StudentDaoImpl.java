package com.leo.dao.impl;

import com.leo.dao.StudentDao;
import com.leo.mapper.StudentMapper;
import com.leo.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

// 将StudentDaoImpl声明为Bean
@Component("studentDao")
public class StudentDaoImpl implements StudentDao{
	// 通过注解注入JdbcTemplate
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int add(Student student) {
		String sql = "insert into student (name,qq,profession,school,create_time,update_time) values (?,?,?,?,?,?)";
		int result = jdbcTemplate.update(sql,student.getName(),student.getQq(),
				student.getProfession(),student.getSchool(),student.getCreate_time(),student.getUpdate_time());
		return result;
	}
	
	@Override
	public Student findById(int id) {
		String sql = "select * from student where id=?";
		Student student = jdbcTemplate.queryForObject(sql, new Object[]{id}, new StudentMapper());
		return student;
	}
	
	@Override
	public void update(int id, String name) {
		String sql = "update student set name=? where id=?";
		jdbcTemplate.update(sql,name,id);
		System.out.println("Updated Record with ID="+id);
	}
	
	@Override
	public void delete(int id) {
		String sql = "delete from student where id=?";
		jdbcTemplate.update(sql,id);
		System.out.println("Deleted Record with ID="+id);
	}
	
	@Override
	public List<Student> findAll() {
		String sql = "select * from student";
		List<Student> students = jdbcTemplate.query(sql,new StudentMapper());
		return students;
	}
}
