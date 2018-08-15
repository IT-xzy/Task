package com.jnshu.mapper;

import com.jnshu.model.UserAuth;

/**
 * @program: taskTwo
 * @description: 登陆验证 Cookie
 * @author: Mr.xweiba
 * @create: 2018-05-21 15:55
 **/

public interface UserAuthDao {
    boolean userAuth(UserAuth userAuth);
    UserAuth findUserAuthbyName(String au_username);
    boolean findUserAuthByid(Integer id);
}
