package com.ppteng.service;

import com.ppteng.pojo.Student;

import java.util.List;

public interface CrudService {
    //插入一个学员信息并且返回主键
    //操作失败返回null
    public long addAStudent(Student student) throws Exception;

    //删除一个学员信息,并返回文字信息
    public boolean deleteAStudent(Long primeKey) throws Exception;

    //通过主键来查询一个学员,并返回文字信息
    public Student findByPrimeKey(Long primekey) throws Exception;

    //通过姓名模糊查询,并返回文字信息
    public List<Student> findStudentsByName(String name) throws Exception;

    //通过学号精确查找,并返回文字信息
    public Student findAStudentByNum(String online_num) throws Exception;

    //更新信息,并返回文字信息
    public boolean updateInformation(Student student) throws Exception;

    //清空表格
    public void deleteAll() throws Exception;
}
