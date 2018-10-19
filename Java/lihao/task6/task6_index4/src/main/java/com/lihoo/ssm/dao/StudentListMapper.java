package com.lihoo.ssm.dao;

import com.lihoo.ssm.model.StudentList;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StudentListMapper {
    int deleteByPrimaryKey(Long id);

    int insert(StudentList record);

    StudentList selectByPrimaryKey(Long id);

    List<StudentList> selectAll();

    int updateByPrimaryKey(StudentList record);

    List<StudentList> getJavaList();

    List<StudentList> getWebList();
}