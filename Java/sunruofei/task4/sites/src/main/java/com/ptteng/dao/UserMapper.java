package com.ptteng.dao;

import com.ptteng.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserMapper {
    int insert(User record);
    List<User> selectByName(String name);
    List<User> selectByCondition(@Param("name") String name , @Param("password") String password);
}
