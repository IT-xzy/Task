package com.lihoo.sm.service;

import com.lihoo.sm.model.User;

import java.util.List;

/**
 * @author lihoo
 * @Title: UserService
 * @ProjectName spring_mybatis_1
 * @Description: TODO
 * @date 2018/8/2-18:33
 */

@SuppressWarnings("unused")
public interface UserService {

    //增加 用户
    int addUser(User user) throws Exception;

//    //删除 用户通过id
    int deleteUser(int id) throws Exception;
//
//    //更改用户信息通过
    void updateUser(User user) throws Exception;

    //查找用户列表
    List<User> findUserList() throws Exception;

    //通过姓名查找 用户
    User findUserByName(String username) throws Exception;

    // 根据 id 查询用户信息
    User findUserById(int id) throws Exception;


}
