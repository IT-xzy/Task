package com.leo.mapper;

import com.leo.pojo.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements RowMapper<Student> {
	
	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Student student = new Student();
		student.setId(rs.getLong("id"));
		student.setName(rs.getString("name"));
		student.setQq(rs.getInt("qq"));
		student.setProfession(rs.getString("profession"));
		student.setSchool(rs.getString("school"));
		student.setCreate_time(rs.getLong("create_time"));
		student.setUpdate_time(rs.getLong("update_time"));
		
		return student;
	}
}
