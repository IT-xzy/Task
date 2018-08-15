package com.jnshu.service;

import com.jnshu.model.*;

import java.util.List;

public interface UserService {
    /* 根据条件查找用户 */
    List<UserCustom> findUserMore(UserQV userQV) throws Exception;

    /* 根据id查找用户 */
    UserCustom findUserById(Integer id) throws Exception;

    /* 返回影响行数 0即代表false true 非 0 */
    int insertUser(UserCustom userCustom) throws Exception;

    /* 返回影响行数 0即代表false true 非 0 */
    boolean deleteUser(Integer i) throws Exception;

    /* 返回影响行数 0即代表false true 非 0 */
    boolean updateUser(UserCustom userCustom, Integer id) throws Exception;

    /* 返回查询结果 session 方式*/
    boolean findAuth(Auth auth) throws Exception;

    // 验证账号信息
    boolean userAuth(UserAuth userAuth);

    // 通过用户名查找账号信息
    UserAuth findUserAuthByName(String au_username);

    // 通过id查找账号信息
    Boolean findUserAuthByid(Integer id);
}
