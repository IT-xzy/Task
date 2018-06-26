package com.jnshu.mapper;

import com.jnshu.model.User;
import com.jnshu.model.UserCustom;
import com.jnshu.model.UserQV;

import java.util.List;

public interface UserDao {
    //为空时查找所有用户
    List<UserCustom> findUserMore(UserQV userQV) throws Exception;

    //根据id查找用户
    UserCustom findUserById(Integer id) throws Exception;

    //返回影响行数 0即代表false true 非 0
    Integer insertUser(User user) throws Exception;

    //返回返回影响行数 0即代表false true 非 0
    boolean deleteUser(int i) throws Exception;

    //返回返回影响行数 0即代表false true 非 0
    boolean updateUser(UserCustom userCustom) throws Exception;
}
