package com.mybatis.mapper;

import com.mybatis.bean.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author gacl
 * 定义sql映射的接口，使用注解指明方法要执行的SQL
 */
public interface UserMapperI {

    //使用@Insert注解指明add方法要执行的SQL
    @Insert("insert into t_student(name, age) values(#{name}, #{age})")
    public int add(Student student);

    //使用@Delete注解指明deleteById方法要执行的SQL
    @Delete("delete from t_student where id=#{id}")
    public int deleteById(long id);

    //使用@Update注解指明update方法要执行的SQL
    @Update("update t_student set name=#{name},age=#{age} where id=#{id}")
    public int update(Student student);

    //使用@Select注解指明getById方法要执行的SQL
    @Select("select * from t_student where id=#{id}")
    public Student getById(long id);

    //使用@Select注解指明getAll方法要执行的SQL
    @Select("select * from t_student")
    public List<Student> getAll();
}