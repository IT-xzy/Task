package com.jnshu.dao;

import com.jnshu.model.User;
import org.apache.ibatis.annotations.Param;


public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);


    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByIdAndName(User user);

    User selectByName(String userName);

    int updateByName(User login);

    int updateImageByName(@Param("userName") String userName, @Param("userImage")String image);
}