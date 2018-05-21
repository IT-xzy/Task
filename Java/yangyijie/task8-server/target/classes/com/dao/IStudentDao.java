package com.dao;

import com.bean.Student;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Arike
 * Create_at 2017/12/1 14:12
 */
@Repository
public interface IStudentDao {
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
    List<Student> findByPage(HashMap<String,Object> map);
}
