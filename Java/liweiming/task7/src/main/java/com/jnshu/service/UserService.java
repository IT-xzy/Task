package com.jnshu.service;


import com.jnshu.entity.User;

import java.util.List;

public interface UserService {
    /** 获取所有信息*/
    List<User> getAllUser()throws Exception;
    /**根据id获得对象信息*/
    User getUserById(int id) throws Exception;

    List<User> getUserMore(User user)throws Exception;
    //    添加信息

    int saveUser(User user)throws Exception;
    //    根据id删除信息

    boolean deleteUser(int id)throws Exception;

    //    更新信息

    boolean updateUser(int id, User user)throws Exception;


}
