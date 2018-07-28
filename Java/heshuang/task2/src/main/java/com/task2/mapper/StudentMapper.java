package com.task2.mapper;
import com.task2.pojo.Student;

import java.util.HashMap;
import java.util.List;

public interface StudentMapper {
    //查询
    Student getStudentById(Long id) throws Exception;
    List<Student> getStudentsListByName(String name) throws Exception;
    List<Student> getAllStudents() throws Exception;
    //删除
    Integer deleteStudentById(Long id) throws Exception;
    //新增
    int saveStudent(Student student) throws Exception;
    //更新
    Integer updateStudent(Student student) throws Exception;
    //根据分页查询，sql select * from t_students limit start,size
    List<Student> findByPage(HashMap<String,Object> hashMap) throws Exception;
    Integer getCount() throws Exception;
}
