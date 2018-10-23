package com.suger.service;

import com.suger.pojo.Page;
import com.suger.pojo.Student;

import java.util.List;

/**
 * service接口，目前z只是简单的调用dao接口
 * @author suger
 * @date 2018-10-02
 */
public interface StudentService {
    Long addStudent(Student student);

    Boolean updateStudent(Student student);

    Boolean deleteStudent(Long id);

    List<Student> findAll(Page page);

    List<Student> findAll();

    int total();

    Student getStudentById(Long id);

    List<Student> getStudentByName(String name);

    List<Student> getStudentByonlineId(int onlineId);

}
