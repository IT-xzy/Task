package com.art.service;

import com.art.pojo.User;

import java.util.List;

/**
 * 用户管理
 * @author suger
 * @date 2018-11-04
 */
public interface UserService {

    // 新增用户
    Boolean insert(User record);
    // 根据主键查询用户
    User getUser(Integer id);
    //  查询用户列表
    List<User> getUser(User record);
     // 删除用户
    Boolean delete(Integer id);
    // 更新用户
    Boolean update(User record);

}
