package com.dao;

import com.pojo.Student;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface StudentMapper {
    //根据id值查找学生
    Student selectStudentById(int id);
    //根据名字查找学生
    Student selectStudentByName(String name);
    //插入一条关于学生的数据
    int insertStudent(Student student);
    //根据id值删除学生
    int deleteStudentById(int id);
    //更新学生数据
    int updateStudentById(Student student);
    //查询学生全表
    List<Student> selectStudent();
}
