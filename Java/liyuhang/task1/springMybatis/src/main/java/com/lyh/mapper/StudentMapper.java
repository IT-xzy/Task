package com.lyh.mapper;

import com.lyh.pojo.Student;

import java.util.List;

public interface StudentMapper {
    public void addStudent(Student student);
    public int deleteStudent(int id);
    public int updateStudent(Student student);
    public List<Student> selectById(int id);
    public List<Student> selectByName(String name);
    public List<Student> selectAll();
}
