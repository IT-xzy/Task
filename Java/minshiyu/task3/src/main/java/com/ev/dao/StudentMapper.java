package com.ev.dao;

import com.ev.model.Student;

import java.util.HashMap;
import java.util.List;

public interface StudentMapper {

    //增
    boolean insertStudent(Student student);

    //删
    boolean deleteStudent(Long id);

    //根据姓名查找
    List<Student> findByName(String name);

    //根据学号查找
    List<Student> findByNumber(String number);

    //根据id查找
    Student findById(Long id);

    //改
    boolean updateStudent(Student student);

    //reset
    void reset();

    //分页相关
    List<Student> findByPage(HashMap<String,Object> map);

    List<Student> selectStudentList();

    int selectCount();
}
