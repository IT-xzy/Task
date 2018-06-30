package com.DAO;

import com.POJO.*;
import org.apache.ibatis.annotations.Param;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public interface LoginMapper {

    Student findUserById(Long ID) throws IOException;//查询
//    List<Student> findAll(Page page) throws IOException;//查询
    List<Student> findAll(HashMap<String, Object> map);
//    List<Student> findUserByName(String name)throws IOException;
    List<Student> findUserByName(HashMap<String, Object> map)throws IOException;
    //模糊查询（查询结果不一定只有一个，所以将查询结果放入List集合中。
    int insertUser(Student student) throws  Exception;//增加
    int deleteUser(int id) throws  Exception;//删除指定id的记录
    int updateUser(Student student) throws Exception;//更改指定id的数据
    int selectCount2(String name);
    //task-4
    //优秀学员
    List<GoodStudent> findGood();
    //在线学习人数
    int selectCount();
    //毕业学员人数
    int selectCountGraduate();
    //查找页面前三张图片
    List<Images1> findImgaes1();
    //查找第一种职业的数据 test3页面中使用
    List<JobList> findJobList1();
   //登陆账户验证
    SignIn clientLogin(/*@Param("account")*/ String account);
    //注册功能
    int register(SignIn signIn);
}
