package com.ev.dao;

import com.ev.bean.Student;

import java.util.List;

public interface StudentMapper {

    //根据id查询用户信息
    List<Student> findById(Long id) throws Exception;

    //根据姓名模糊查询
    List<Student> findByName(String name) throws Exception;

    //根据姓名模糊查询
    List<Student> findByNumber(String number) throws Exception;

    //添加用户信息
    boolean insertStudent(Student student) throws Exception;

    //删除用户信息
    boolean deleteStudent(Long id) throws Exception;

    //更新用户信息
    boolean updateStudent(Student student) throws Exception;

    //清除所有用户信息
    void reset() throws Exception;

}
