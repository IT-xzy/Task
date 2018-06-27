package com.ev.service;


import com.ev.model.PageBean;
import com.ev.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StudentService {

    //   插入一个学员信息并且返回主键
    Long addAStudent(Student student) throws Exception;


    //删除一个学员信息
    boolean deleteAStudent(Long primeKey) throws Exception;

    //通过主键来查询一个学员
    Student findStudentById(Long id) throws Exception;

    List<Student> findStudentByName(String name) throws Exception;

    //通过学号精确查找
    List<Student> findStudentByNumber(String online_num) throws Exception;

    //更新信息
    boolean updateStudent(Student student) throws Exception;

    //清空表格
//    void reset() throws Exception;

    //查询所有用户数据
    List<Student> selectStudentList() throws Exception;

    //查询用户记录总数
    int selectCount() throws  Exception;

    //根据分页数据start 和size查询数据
    PageBean<Student> findByPage(int currentPage) throws  Exception;
}
