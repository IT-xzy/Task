package com.wszhan.mapper;

import com.wszhan.pojo.Student;

import java.util.List;

/**
 * @author Weisi Zhan
 * @create 2018-10-30 11:27
 **/
public interface StudentMapper {
    //根据 id 查询 user 表数据
    Student selectStudentById(int id) throws Exception;

    //向 user 表插入一条数据
    int insertStudent(Student user) throws Exception;

    //根据 id 修改 user 表数据
    boolean updateStudentById(Student user) throws Exception;

    //根据 id 删除 user 表数据
    boolean deleteStudentById(int id) throws Exception;

    //返回所有user
    List<Student> selectStudentAll() throws Exception;
}
