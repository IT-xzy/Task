package com.jnshu.service;

import com.jnshu.entity.profession;
import com.jnshu.entity.student;
import com.jnshu.entity.user;
/*import com.jnshu.entity.user;*/

import java.util.List;

public interface StudentService {

    List<student> findAll();
    List<profession> findAlls();
    int findName();
    profession addlist(profession profession);




    //登录和注册
    boolean AuUser(user user);

    user login(String name);

    public void register(user user);

    Boolean findUserByid(Integer id);

    user findUserByname(String name);

/*
    //user
    boolean findUser(user user)throws Exception;*/
    //注册
 /*   void regist(user user);
    //登录
    void login(String name,String password);*/

/*    //账号登录信息
    boolean userAll(user user);
    //通过姓名查找账户信息
    user findUserbyName(String name);
    //通过id查找账户信息
    boolean findUserById(int id);

    user getuserCountByNameAndPassword(user user);*/

/*    student queryId(int id) throws Exception;

    List<student> queryName(String student) throws Exception;

    boolean addUser(student student) throws Exception;

    boolean updateUser(student student) throws Exception;

    boolean deleteUser(int id) throws Exception;*/

}
