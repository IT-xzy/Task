package com.myspring.di.context;


import java.util.List;

/**
 * @author Arike
 * Create_at  2017/11/20 14:57
 */

public interface StudentMapper {
    //通过ID查询
    Student getStudentById(long id)throws Exception;
    
    //通过name模糊查询
    List<Student> getStudentByName(String name)throws Exception;
    
    //更新
    void updateStudent(Student student)throws Exception;
    
    //插入
    void insertStudent(Student student)throws Exception;
    
    //删除
    void deleteStudent(long[] arr)throws Exception;
    
}
