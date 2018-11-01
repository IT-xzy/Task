package com.wszhan.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import com.wszhan.pojo.Student;

import java.util.List;

/**
 * @author Weisi Zhan
 * @create 2018-10-30 11:27
 **/
@Repository
public interface StudentMapper {
    //根据 id 查询 user 表数据
//    @Select("SELECT * FROM student WHERE id = #{id}")
    Student selectStudentById(int id) throws Exception;

    //向 user 表插入一条数据
//    @Insert("INSERT INTO student(name, age) VALUE (#{name}, #{age})")
//    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Options(useGeneratedKeys=true)
    int insertStudent(Student student) throws Exception;

    //根据 id 修改 user 表数据
//    @Update("UPDATE student SET name=#{name}, age=#{age} WHERE id=#{id}")
//    @Result(jdbcType = JdbcType.BOOLEAN)
    int updateStudentById(Student student) throws Exception;

    //根据 id 删除 user 表数据
//    @Delete("DELETE FROM student WHERE id=#{id}")
//    @Result(jdbcType =  JdbcType.BOOLEAN)
    int deleteStudentById(int id) throws Exception;

    //返回所有user
//    @Select("SELECT * FROM student LIMIT 10")
    List<Student> selectStudentAll() throws Exception;
}
