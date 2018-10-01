package com.ptteng.dao;

import com.ptteng.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao {

    @Insert("insert into student (name,QQ,wish,createAt,updateAt) values (#{name},#{QQ},#{wish},#{createAt},#{updateAt})")
//   设置返回主键id
    @Options(useGeneratedKeys = true, keyProperty = "id")
    long insertStudent(Student student);

    @Select("select * from student")
    List<Student> findAll();

    @Update("update student set name=#{name},QQ=#{QQ},wish=#{wish},updateAt=#{updateAt} where id=#{id}")
    boolean updateStudent(Student student);

    @Delete("delete from student where id=#{id}")
    boolean deleteStudent(long id);

    @Select("select * from student where id=#{id}")
    List<Student> findById(long id);

    @Select("select count(*) from student")
    long count();

    @Select("select * from student limit #{pageStart},10")
    List<Student> findPage(long pageStart);
}
