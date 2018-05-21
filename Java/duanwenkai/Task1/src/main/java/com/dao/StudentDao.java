package com.dao;

import com.entity.Student;

import java.util.List;

/**
 * @Description:
 * @ClassName:
 * @author: fml<duanweikai>
 * @date: 2018/3/6 11:09
 * @version: [1.0]
 */

public interface StudentDao {
    void add(Student student);
    int delete(int id);
    int deleteAll();
    int update(Student student);
    Student selectById(int id);
    List<Student> selectByName(String name);
    List<Student> selectAll();
    int selectCount();
}
