package com.jnshu.mybatis.dao;

import com.jnshu.mybatis.user.User;

import java.util.List;

public interface UserDao {
    //根据id查询用户信息
    public User findUserById(int id) throws Exception;
    //根据用户名模糊查询
    public List<User> findUserByName(String name) throws Exception;
    //public List<User> findUserList(List<Integer> ids) throws Exception;
}
