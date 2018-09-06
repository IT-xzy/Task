package com.iceneet.dao;

import com.iceneet.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int registerUser(User user);

    User userMatch(User user);

    User selectByName(String name);
}