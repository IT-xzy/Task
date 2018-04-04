package com.ptteng.dao;

import com.ptteng.model.Student;
import java.util.HashMap;
import java.util.List;

public interface StudentDao {
    //查询
    Student getStudentById(Long id) throws Exception;
    List<Student> getStudentsListByName(String name) throws Exception;
    List<Student> getAllStudents() throws Exception;
    //删除
    Boolean deleteStudentById(Long id) throws Exception;
    //新增
    Integer saveStudent(Student student) throws Exception;
    //更新
    Boolean updateStudent(Student student) throws Exception;
    //根据分页查询，sql select * from t_students limit start,size
    List<Student> getStudentsListByPage(HashMap<String,Object> hashMap) throws Exception;
    Integer getCount() throws Exception;
}
