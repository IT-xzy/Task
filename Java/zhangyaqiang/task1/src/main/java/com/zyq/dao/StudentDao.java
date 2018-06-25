package com.zyq.dao;

import com.zyq.domain.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

import java.util.List;

public interface StudentDao {
//    原生JDBC、JdbcTemplate、Mybatis和Spring与Mybatis整合使用此接口
    Long insert(Student student);
    boolean deleteById(Student student);
    boolean update(Student student);
    Student selectById(Long id);
    List<Student> selectByNameAndNum(String name, Integer number);
}
