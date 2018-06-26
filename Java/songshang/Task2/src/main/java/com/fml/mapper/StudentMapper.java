package com.fml.mapper;

import com.fml.pojo.Student;
import com.fml.utils.Page;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @ClassName:
 * @author: fml<duanweikai>
 * @date: 2018/3/10 14:04
 * @version: [1.0]
 */
public interface StudentMapper {
    int add(Student student);
    int delete(int id);
    int deleteAll();
    int update(Student student);
    Student selectById(int id);
    List<Student> selectByName(String name);
    List<Student> selectAll(Map map);
    int selectCount();
}
