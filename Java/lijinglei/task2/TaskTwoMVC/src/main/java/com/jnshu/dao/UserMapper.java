package com.jnshu.dao;

import com.jnshu.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    List<User> getAll();
    User selectByIdAndName(User user);
    List<User> getPage(@Param("pageNo") Integer pageNo, @Param("SHOW_ITEMS") Integer SHOW_ITEMS);
    int countAll();
}