package com.service;

import com.entity.Student;

import java.util.List;

/**
 * @Description:
 * @ClassName:
 * @author: fml<duanweikai>
 * @date: 2018/3/6 11:37
 * @version: [1.0]
 */
public interface StudentService {
    int add(Student student);
    String delete(int id);
    String deleteAll();
    String update(Student student);
    Student selectById(int id);
    List<Student> selectByName(String name);
    List<Student> selectAll();
    int selectCount();
}
