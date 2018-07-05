package com.task2.service;

import com.task2.pojo.User;

import java.util.List;

public interface UserService {

    public int findUserCount() throws Exception;

    public List<User> findUserByPage(int start, int pageSize) throws Exception;

    //    新增
    long insertUser(User user);

    //    修改
    boolean updateUser(User user);

    //根据id查询
    User findUserById(long id);

    //    根据id删除
    boolean deleteUserById(long id);

    //    动态查询
   List<User> selectUser(User user);
}
