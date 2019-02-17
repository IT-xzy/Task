package com.ptteng.service;

import com.ptteng.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    int insert(User record);
    List<User> selectByName(String name);
    List<User> selectByCondition(@Param("name")String name , @Param("password")String password);
}
