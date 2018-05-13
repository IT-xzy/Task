package com.mappers;

import com.POJO.User;

/**
 * @author: 曹樾
 * @program: task5-module
 * @description: 登录拦截
 * @create: 2018/5/7 下午8:40
 */

public interface LoginMapper {
    int deleteByPrimaryKey(Integer id);
    
    int insert(User record);
    
    int insertSelective(User record);
    
    User selectByPrimaryKey(Integer id);
    
    int updateByPrimaryKeySelective(User record);
    
    int updateByPrimaryKey(User record);
    
    User selectByUser(User user);
    
    User findUserByname(String name);
}
