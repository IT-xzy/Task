package com.jnshu.taskone.service;

import com.jnshu.taskone.model.User;

import java.util.List;

public interface UserService {
    List<User> findUserAll() throws Exception;
    List<User> findUserMore(User user) throws Exception;
    /* 返回影响行数 0即代表false true 非 0 */
    int insertUser(User user) throws Exception;
    boolean deleteUser(int i) throws Exception;
    boolean updateUser(User user) throws Exception;
    void forlist(List<User> user);
}
