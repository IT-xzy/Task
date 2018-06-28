package com.service;
import com.pojo.Student;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IFStudentService {
    //根据id值查找学生
    Student findStudentById(int id);
    //根据名字查找学生
    Student findStudentByName(String name);
    //插入一条关于学生的数据
    boolean inputStudent(Student student);
    //根据id值删除学生
    boolean outputStudentById(int id);
    //更新学生数据
    boolean replayStudent(Student student);
    //查询学生全表
    List<Student> findStudent();
}
