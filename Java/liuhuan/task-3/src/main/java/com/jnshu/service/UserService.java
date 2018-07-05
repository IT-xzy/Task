package com.jnshu.service;

import com.jnshu.model.Auth;
import com.jnshu.model.User;
import com.jnshu.model.UserCustom;
import com.jnshu.model.UserQV;

import java.util.List;

public interface UserService {
    /* 根据条件查找用户 */
    List<UserCustom> findUserMore(UserQV userQV) throws Exception;

    /* 根据id查找用户 */
    UserCustom findUserById(Integer id) throws Exception;

    /* 返回影响行数 0即代表false true 非 0 */
    int insertUser(User user) throws Exception;

    /* 返回影响行数 0即代表false true 非 0 */
    boolean deleteUser(Integer i) throws Exception;

    /* 返回影响行数 0即代表false true 非 0 */
    boolean updateUser(UserCustom userCustom, Integer id) throws Exception;

    /* 返回查询结果 */
    boolean findAuth(Auth auth) throws Exception;
}
