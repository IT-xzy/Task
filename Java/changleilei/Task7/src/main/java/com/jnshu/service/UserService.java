package com.jnshu.service;
import com.jnshu.model.User;

public interface UserService {
    int deleteById(Integer id);
    int insert(User record);
    int insertSelective(User record);
    com.jnshu.model.User selectById(Integer id);
    int updateByIdSelective(User record);
    int updateById(User record);
    int countByName(String name);
}
