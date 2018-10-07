package com.leo.dao;

import com.leo.model.Student4;

import java.util.List;

public interface Student4Mapper {
    int deleteByPrimaryKey(Long id);

    int insert(Student4 record);

    Student4 selectByPrimaryKey(Long id);

    List<Student4> selectAll();

    int updateByPrimaryKey(Student4 record);
    
    List<Student4> selectExcellentStudent();
    
    int total();
    
    int isWork();
    
    // job:html,java,python,js,ios,andriod
    int jobCount(String job);
}