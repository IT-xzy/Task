package com.suger.dao;

import com.suger.pojo.Page;
import com.suger.pojo.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * created by suger on 2018/10/2
 * 持久层接口, 结合Mapper.xml,使用扫描包的方式
 * CRUD,主要加入查总记录数，配合分页查询，
 * 根据id查询，配合修改
 */
@Repository
public interface StudentDao {
    Long addStudent(Student student);
    int updateStudent(Student student);
    int deleteStudent(Long id);
    // 2个查全表
    // 使用mybatis的动态语句,有参，使用:limit ; 无参的话，直接查全表
    // 前台已经做好分页显示
    List<Student> findAll(Page page);
    List<Student> findAll();
    // 查总记录数
    int total();
    Student getStudentById(Long id);
    List<Student> getStudentByName(String name);
    List<Student> getStudentByonlineId(int onlineId);
}
