package com.ptteng.service;

import com.ptteng.model.PageBean;
import com.ptteng.model.Student;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

public interface StudentService {
//    查询
    Student getStudentById(Long id) throws Exception;
    List<Student> getStudentsListByName(String name) throws Exception;
    List<Student> getAllStudents() throws Exception;
//    删除
    Boolean deleteStudentById(Long id) throws Exception;
//    新增
    Integer saveStudent(Student student) throws Exception;
//    更新
    Boolean updateStudent(Student student) throws Exception;
//    分页查询
    PageBean<Student> getStudentsByPage(int currentPage) throws Exception;
}
