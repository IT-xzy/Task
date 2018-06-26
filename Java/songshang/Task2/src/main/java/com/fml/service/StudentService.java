package com.fml.service;

import com.fml.pojo.Student;
import com.fml.utils.Page;

import java.util.List;

/**
 * @Description:
 * @ClassName:
 * @author: fml<duanweikai>
 * @date: 2018/3/10 14:09
 * @version: [1.0]
 */
public interface StudentService {
    int add(Student student);
    int delete(int id);
    int deleteAll();
    int update(Student student);
    Student selectById(int id);
    List<Student> selectByName(String name);
    Page<Student> selectAll(int currPage);
    int selectCount();
}
