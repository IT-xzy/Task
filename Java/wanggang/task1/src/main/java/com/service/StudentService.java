package com.service;

import com.entity.Student;

import java.util.List;

public interface StudentService {
    boolean addStudent(Student student) throws Exception;        //单例插入
    boolean deleteById(Student student) throws Exception;        //通过id和学号删除
    boolean updateByName(Student student) throws Exception;      //更新数据
    List<Student> findAll() throws Exception;                    //查询所有
    Student findByName(Student student) throws Exception;        //通过关键字搜索
    List<Student> findByLike(Student student) throws Exception;  //模糊查询
    Integer insertBatch(List list) throws Exception;             //批量插入
    void truncate() throws Exception;                         //清除所有数据
}
