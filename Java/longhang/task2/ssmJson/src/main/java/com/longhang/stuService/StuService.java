package com.longhang.stuService;


import com.longhang.stuModel.Student;

import java.util.List;

public interface StuService{
    Student getStuById(Long id);
    void getInsert(Student student);
    boolean getDelete(Long id);
    List<Student> getGetAll();
    boolean getUpdate(Student student);
    Student getStu(Student student);


}
