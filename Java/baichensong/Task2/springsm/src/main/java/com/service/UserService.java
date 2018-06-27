package com.service;

import com.page.Page;
import com.pojo.User;

import java.util.List;

public interface UserService {
    User findUserById(int id);
    int insertUser(User user);
    void deleteUserId(int id);
    List<User> AllId();
    //分页 数据传递
    List<User> AllId(Page page);
    void updateUser(User  user);
    List<User> findName(User user);
    //用来 实现 跳转到更改数据编辑器的 方法。
    User get(int id);
    //返回 列表数目
    int total();



}
