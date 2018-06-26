package com.hzw.service;

import com.hzw.pojo.Student;
import com.hzw.util.Page;

import java.util.List;

public interface StudentService {
    List<Student> getAll();

    void addStu(Student student);

    void deleteStu(long s_id);

    void updateStu(Student student);

    Student getId(long s_id);


    //增加total用于获取所有
    //增加 getAll(Page page)，根据分页来查询数据
//    int total();
//
//    List<Student> getAll(Page page);

}
