package com.service;

import com.pojo.Student;

import java.util.List;

public interface Service2 extends Service0{
    //根据id值查找学生
    Student findStudentById(long id);
    //根据名字查找学生
    Student findStudentByName(String name);
    //插入一条关于学生的数据
    boolean inputStudent(Student student);
    //根据id值删除学生
    boolean outputStudentById(long id);
    //更新学生数据
    boolean replayStudent(Student student);
    //查询学生全表
    List<Student> findStudent();
}
