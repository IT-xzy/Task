package com.hzw.mapper;

import com.hzw.pojo.Student;

import java.util.List;

public interface StudentMapper {
    void addStu(Student student);

    boolean deleteStu(long s_id);

    boolean updateStu(Student student);

    Student getId(long s_id);


    List<Student> getAll();

    List<Student> getName(Student student);
}
