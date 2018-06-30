package com.service;

import com.POJO.*;

import java.io.IOException;
import java.util.List;

/**
 * User类业务层接口
 */
public interface LoginService {
    Student findUserById(Long ID) throws IOException;//查询
    //    List<Student> findAll(Page page) throws IOException;//查询
//    List<Student> findUserByName(String name)throws IOException;
//    List<Student> findUserByName(HashMap<String,Object> map)throws IOException;
    //模糊查询（查询结果不一定只有一个，所以将查询结果放入List集合中。
    int insertUser(Student student) throws  Exception;//增加
    int deleteUser(int id) throws  Exception;//删除指定id的记录
    int updateUser(Student student) throws Exception;//更改指定id的数据
    int selectCount2(String name);


    //task-4
    List<GoodStudent> findGood();
    int selectCount();
    int selectCountGraduate();
    List<Images1> findImgaes1();
    //查找第一种职业的数据 test3页面中使用
    List<JobList> findJobList1();
    SignIn clientLogin(String account);
    int register(SignIn signIn);
}
