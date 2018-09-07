package com.task2.service;
import com.task2.pojo.Page;
import com.task2.pojo.Student;
import java.util.List;

public interface StudentService {
    //    查询
    Student getStudentById(Long id) throws Exception;
    List<Student> getStudentsListByName(String name) throws Exception;
    List<Student> getAllStudents() throws Exception;
    Integer getCount() throws Exception;
    //    删除
    Integer deleteStudentById(Long id) throws Exception;
    //    新增
    int saveStudent(Student student) throws Exception;
    //    更新
    Integer updateStudent(Student student) throws Exception;
    //    分页查询
    Page<Student> findByPage(int currentPage) throws Exception;

//    List<Student> nameAndOnline_id(String name, String online_id) throws Exception;
}
