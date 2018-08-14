package com.alibaba.dao;

import com.alibaba.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao {
    void deleteById(Long id);
    int insert(Student student);
    int insertSelective(Student student);
    Student selectById(Long id);
    boolean updateByIdSelective(Student student);
    boolean updateById(Student student);
    List<Student> selectAll();
    int countAll();
    Student selByName(String name);
}
