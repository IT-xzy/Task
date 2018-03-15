package com.mybatis.DAO;

import com.mybatis.bean.Student;

import java.util.List;

/**
 * @author Arike
 * Create_at  2017/11/20 14:22
 */
public interface IStudentDAO {
    //增加
    void insertStudent(Student student);
    //删除
    void deleteStudent(long id);
    //改变更新
    void updateStudent(Student student);
    //根据ID查询一个
    void selectOne(long id);
    
  //根据名称模糊查询
    void selectAll(String name);
}
