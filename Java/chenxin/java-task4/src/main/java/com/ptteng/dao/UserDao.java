package com.ptteng.dao;

import com.ptteng.model.User;

import java.util.List;

public interface UserDao {
    //新增用户
    boolean saveUser(User user) throws Exception;
    //通过用户名查找
    List<User> getUserByName(String username) throws Exception;
    //删除用户，用于注销账号
    boolean deleteUserById(long id) throws Exception;
    //更新用户信息，用于修改密码
    boolean updateUser(User user) throws Exception;
//    User validateUser(Login login);
}
