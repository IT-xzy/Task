package com.mybatis_spring.dao;

import com.mybatis_spring.bean.Student;

import java.util.List;

/**
 * @author Arike
 * Create_at 2017/12/1 14:12
 */
public interface IStudentDao {
    //通过ID查询
    Student getStudentById(Long id)throws Exception;
    
    //通过name模糊查询
    List<Student> getStudentByName(String name)throws Exception;
    
    //更新
    void updateStudent(Student student)throws Exception;
    
    //插入
    void insertStudent(Student student)throws Exception;
    
    //删除
    void deleteStudent(Long []arr)throws Exception;
    
}
