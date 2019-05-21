package com.jnshu.dao;

import com.jnshu.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author pipiretrak
 * @date 2019/4/3 - 2:09
 */
public interface UserMapper {
    int insert(User record);
    List<User> selectByName(String name);
    List<User> selectByNameAndPassword(@Param("name") String name , @Param("password") String password);
    User selectById(Long id);
}
