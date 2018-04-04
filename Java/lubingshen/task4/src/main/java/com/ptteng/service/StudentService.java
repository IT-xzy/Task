package com.ptteng.service;

import com.ptteng.bean.PageBean;
import com.ptteng.bean.Student;

import java.util.List;

public interface StudentService {

    //查询所有在学学员的数量
    public int countStudent();
    //查询所有学员的信息
    public PageBean<Student> findByPage(int currentPage);
    //插入一个学员信息并且返回主键
    public long addAStudent(Student student) throws Exception;
    //删除一个学员信息
    public boolean deleteAStudent(Long primeKey) throws Exception;
    //通过主键来查询一个学员
    public Student findByPrimeKey(Long primekey) throws Exception;
    //通过姓名模糊查询
    public List<Student> findStudentsByName(String name) throws Exception;
    //通过学号精确查找
    public Student findAStudentByNum(String online_num) throws Exception;
    //更新信息
    public boolean updateInformation(Student student) throws Exception;
}

