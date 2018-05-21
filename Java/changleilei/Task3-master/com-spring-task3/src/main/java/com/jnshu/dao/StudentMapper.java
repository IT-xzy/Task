package com.jnshu.dao;
import com.jnshu.model.Student;

import java.util.List;

public interface StudentMapper {
    Student selectById(Integer id );

    int deleteById( Integer id );

    int insert( Student record );

    int insertSelective( Student record );

    int updateByIdSelective( Student record );

    int updateById( Student record );

    int countStudentById( int id );

    List<Student> getAllStudent( );
}
