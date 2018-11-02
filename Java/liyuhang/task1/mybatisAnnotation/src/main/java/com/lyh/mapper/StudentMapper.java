package com.lyh.mapper;

import com.lyh.pojo.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StudentMapper {
    @Insert("insert into student(name,qq,wish,school,enrolment_time,type,know_from,create_at,update_at) values (#{name},#{qq},#{wish},#{school},#{enrolmentTime},#{type},#{knowFrom},#{createAt},#{updateAt})")
    @Options(useGeneratedKeys = true)
    public int addStudent(Student student);
    @Delete("delete from student where id = #{id}")
    public int deleteStudent(int id);
    @Update(" update student set name = #{name},qq = #{qq},wish = #{wish},school = #{school},enrolment_time = #{enrolmentTime},type = #{type},know_from = #{knowFrom},create_at = #{createAt},update_at = #{updateAt} where id = #{id}")
    public int updateStudent(Student student);
    @Select("select * from student where id = #{id}")
    public Student selectById(int id);
    @Select("select * from student where  name = #{name}")
    public List<Student> selectByName(String name);
    @Select("select * from student")
    public List<Student> selectAll();
}
