package com.he.dao;
import com.he.pojo.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StudentDao {
    @Insert("insert into students(create_at,name,qq,professional,start_time,university,online_id,daily_url,oath,counselor,city) VALUE" +
            "(#{create_at},#{name},#{qq},#{professional},#{start_time},#{university},#{online_id},#{daily_url},#{oath},#{counselor},#{city})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    void addStudent(Student student);
    @Delete("delete from students where id = #{id}")
    Integer deleteStudent(int id);
    @Update("update students set create_at=#{create_at},name =#{name},qq=#{qq} where id = #{id}")
    Integer updateStudent(Student student);
    @Select("SELECT * FROM students")
    List<Student>list();
    @Select("SELECT * FROM students where online_id = #{online_id}")
    List<Student>selectStudentByOnline_id(int online_id);
    @Select("select * from students where name = #{name}")
    List<Student>findByName(String name);
}
