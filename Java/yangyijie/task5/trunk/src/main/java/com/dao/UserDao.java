package com.dao;

import com.bean.User;

/**
 * @author Arike
 * Create_at 2018/1/6 15:34
 */
public interface UserDao {
    //增加注册用户
    void insertUser(User user);
    //验证登陆
    User loginSelect(User user);
}
