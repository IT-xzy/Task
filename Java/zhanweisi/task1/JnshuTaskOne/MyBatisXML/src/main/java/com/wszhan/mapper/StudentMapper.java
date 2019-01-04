package com.wszhan.mapper;

import org.apache.ibatis.annotations.Options;
import com.wszhan.pojo.Student;

import java.util.List;

/**
 * @author Weisi Zhan
 * @create 2018-10-30 11:27
 **/
public interface StudentMapper {
    //根据 id 查询 student 表数据
    Student selectStudentById(int id) throws Exception;

    //向 student 表插入一条数据
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    int insertStudent(Student student) throws Exception;

    //根据 id 修改 student 表数据
    int updateStudentById(Student student) throws Exception;

    //根据 id 删除 student 表数据
    int deleteStudentById(int id) throws Exception;

    //返回所有student
    List<Student> selectStudentAll() throws Exception;
}
