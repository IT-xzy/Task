package com.service;

import com.POJO.ChangeUtil;
import com.POJO.DateTypeChange1;
import com.POJO.PageBean;
import com.POJO.Student;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
/**
 * User类业务层接口
 */
public interface StudentService {
    Student findUserById(Long ID) throws IOException;//查询
    //    List<Student> findAll(Page page) throws IOException;//查询
//    List<Student> findUserByName(String name)throws IOException;
//    List<Student> findUserByName(HashMap<String,Object> map)throws IOException;
    PageBean<DateTypeChange1> findUserByName(int currentPage, String name) throws IOException;
    //模糊查询（查询结果不一定只有一个，所以将查询结果放入List集合中。
    int insertUser(Student student) throws  Exception;//增加
    int deleteUser(int id) throws  Exception;//删除指定id的记录
    int updateUser(Student student) throws Exception;//更改指定id的数据
    PageBean<DateTypeChange1> findAll(int currentPage);
    int selectCount();
    int selectCount2(String name);
}
