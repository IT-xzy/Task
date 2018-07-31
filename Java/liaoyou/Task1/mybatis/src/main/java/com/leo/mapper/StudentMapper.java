package com.leo.mapper;

import com.leo.pojo.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface StudentMapper {
	@Insert("insert into student (name,qq,profession,school,create_time,update_time) values(#{name},#{qq},#{profession},#{school},#{create_time},#{update_time})")
	public int add(Student student);

	@Delete("delete from student where id=#{id}")
	public void delete(int id);

	@Update("update student set name=#{name},create_time=#{update_time} where id=#{id}")
	public int update(Student student);

	@Select("select * from student")
	public List<Student> list();

	@Select("select * from student where id=#{id}")
	public Student getStudent(int id);
}
