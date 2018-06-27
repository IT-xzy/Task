package com.how2java.mapper;

import com.how2java.pojo.Student;
import com.how2java.util.StudentPage;

import java.util.List;

public interface StudentMapper {

    public int add(Student student);

    public void delete(int id);

    public Student get(int id);

    public int update(Student student);

    public List<Student> list();

    public List<Student> list(StudentPage studentpage);

    public int total();
}
