package com.ev.service;

import com.ev.bean.Student;

import java.util.List;

public interface StudentService {

    //插入一个学员信息并且返回主键
    long addAStudent(Student student) throws Exception;

    //删除一个学员信息
    boolean deleteAStudent(Long primeKey) throws Exception;

    //通过主键来查询一个学员
    List<Student> findByPrimeKey(Long primekey) throws Exception;

    //通过姓名模糊查询
    List<Student> findAStudentsByName(String name) throws Exception;

    //通过学号精确查找
    List<Student> findAStudentByNumber(String online_num) throws Exception;

    //更新信息
    boolean updateInformation(Student student) throws Exception;

    //清空表格
    void reset() throws Exception;
}
