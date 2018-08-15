package com.annotation.dao;


import com.he.pojo.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StudentDao {
    @Insert("INSERT INTO students(create_at,name,qq,professional,start_time,university,online_id,daily_url,oath,counselor,city) VALUE\n" +
            "(#{create_at},#{name},#{qq},#{professional},#{start_time},#{university},#{online_id},#{daily_url},#{oath},#{counselor},#{city})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    public int add(Student student);
    @Delete("delete from students where id =#{id}")
    Integer delete(int id);
    @Update("update students set name=#{name} where id =#{id}")
    Integer update(Student student);
    @Select("select * from students")
     List<Student>list();
    @Select("select * from students where online_id = #{online_id}")
    List<Student> findByOnline_id(int omline_id);
    @Select("select * from students where name = #{name}")
    List<Student> findByName(String name);
}
