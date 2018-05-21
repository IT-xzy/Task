package com.ppteng.dao;

import com.ppteng.pojo.Student;

import java.util.List;

public interface StudentMapper {
    //根据id查询用户信息
    public Student findById(long id) throws Exception;
    //根据姓名模糊查询
    public List<Student> findByName(String name) throws Exception;
    //根据姓名模糊查询
    public Student findByNum(String num) throws Exception;
    //添加用户信息
    public boolean insertStudent(Student stu) throws Exception;
    //删除用户信息
    public boolean deleteStudent(long id) throws Exception;
    //更新用户信息
    public boolean updateStudent(Student stu) throws Exception;
    //清除所有用户信息
    public void truncateTable() throws Exception;
}
