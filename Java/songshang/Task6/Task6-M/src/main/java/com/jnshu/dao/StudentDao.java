package com.jnshu.dao;
import com.jnshu.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao {
    int deleteById(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectById(Integer id);

    int updateByIdSelective(Student record);

    int updateById(Student record);

    List<Student> selectAll();
    int countAll();

}