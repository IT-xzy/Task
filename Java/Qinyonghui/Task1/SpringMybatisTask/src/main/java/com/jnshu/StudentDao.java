package com.jnshu;

import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StudentDao{
    @Insert("INSERT INTO student(name,number,qq,coachName,dailyLink,gradeColleage,create_at,update_at)VALUES(#{name},#{number},#{qq},#{coachName},#{dailyLink},#{gradeColleage},#{create_at},#{update_at})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    void insert(Student student);

    @Delete("DELETE FROM student WHERE id=#{id}")
    boolean delete(long id);

   @Update("UPDATE student SET name=#{name},number=#{number},qq=#{qq},coachName=#{coachName},dailyLink=#{dailyLink},gradeColleage=#{gradeColleage},update_at=#{update_at} WHERE id=#{id}")
    boolean update(Student student);

    @Select("SELECT * FROM student WHERE id=#{id}")
     Student find(long id);

    @Select("SELECT * FROM student")
    List<Student> findAll();
}

