package com.service;

import com.POJO.DateTypeChange1;
import com.POJO.PageBean;
import com.POJO.Student;

import java.io.IOException;

/**
 * @author: Arike
 * @program: page
 * @description: 实现分页
 * @create: 2018/4/12 下午2:47
 */

public interface StudentService {
    Student findUserById(int ID) throws Exception;//查询
    PageBean<DateTypeChange1> findUserByName(int currentPage, String name) throws IOException;//模糊查询（查询结果不一定只有一个，所以将查询结果放入List集合中。
    int insertUser(Student student) throws  Exception;//增加
    int deleteUser(int id) throws  Exception;//删除指定id的记录
    int updateUser(Student student) throws Exception;//更改指定id的数据
    PageBean<DateTypeChange1> findAll(int currentPage);
    int selectCount();
    int selectCount2(String name);
}
