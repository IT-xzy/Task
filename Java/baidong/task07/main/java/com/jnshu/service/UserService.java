package com.jnshu.service;

import com.jnshu.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {

    int insert(User user);

    User selectById(Long id);

    List<User> selectByName(String name);

    List<User> selectByCondition(@Param("name") String name, @Param("password") String password);

    List<User> selectByPhone(@Param("phone") String phone, @Param("code") String code);

    boolean insertByPhone(@Param("phone") String phone, @Param("code") String code);
}
