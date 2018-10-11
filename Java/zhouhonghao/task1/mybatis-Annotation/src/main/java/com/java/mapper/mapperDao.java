package com.java.mapper;

import org.apache.ibatis.annotations.Select;

import java.util.List;

import org.apache.ibatis.annotations.*;
import com.java.Student.Student;

public interface mapperDao {
	@Select("select * from student")
	public List<Student> Show();
	
	@Update("update student set name=#{name} where id=#{id}  ")
	public int Update(Student student);
	
	@Delete(" delete from student where id= #{id}   ")
	public int Delete(int id);
	
	@Insert( "insert into student( id,name,sex,phone,create_at,type,senior ) values (#{id},#{name},#{sex},#{phone},#{create_at},#{type},#{senior})" )
	public int Insert(Student student);
	
	@Select("  select * from   student  where id= #{id}    ")
	public Student GetById(int id);
}
