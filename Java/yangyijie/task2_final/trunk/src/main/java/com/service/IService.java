package com.service;

import com.bean.PageBean;
import com.bean.Student;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Arike
 * Create_at 2017/12/14 11:55
 */

public interface IService {
    //通过ID查询
    Student getStudentById(Long id);
    
    //通过name模糊查询
    List<Student> getStudentByName(String name);
    
    //更新
    void updateStudent(Student student);
    
    //插入
    void insertStudent(Student student);
    
    //删除
    void deleteStudent(Long id);
    
    //查询所有
    List<Student> selectAll();
    
    //查询记录总数
    int selectCount();
    
    //分页查询
    PageBean<Student> findByPage(int currentPage);
}
