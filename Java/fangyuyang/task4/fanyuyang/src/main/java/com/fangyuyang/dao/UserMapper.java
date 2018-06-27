package com.fangyuyang.dao;

import com.fangyuyang.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);
    User selectByName(String name);
    int updateByPrimaryKeySelective(User record);
    int countAll();
    int updateByPrimaryKey(User record);
}