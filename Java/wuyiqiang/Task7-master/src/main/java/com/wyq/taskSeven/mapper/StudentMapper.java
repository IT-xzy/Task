package com.wyq.taskSeven.mapper;

import com.wyq.taskSeven.pojo.Student;
import java.util.List;

public interface StudentMapper {
    int deleteByPrimaryKey(Long studentId);

    int insert(Student record);

    Student selectByPrimaryKey(Long studentId);

    List<Student> selectAll();

    int updateByPrimaryKey(Student record);
}