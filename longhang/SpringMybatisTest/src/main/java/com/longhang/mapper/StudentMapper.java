package com.longhang.mapper;
import com.longhang.model.Student;

import java.util.List;

public interface StudentMapper
{
    void insert(Student student);
    void update(Student student) ;
    void delete(Long id);
    Student select(Long id);
    List<Student> getAll() ;
}
