package com.jnshu.mapper;

import com.jnshu.model.UserAuth;

/**
 * @program: smsdemo
 * @description: 用户认证接口
 * @author: Mr.xweiba
 * @create: 2018-05-29 23:08
 **/

public interface UserAuthDao {
    //查询用户名与密码是否匹配
    Integer userAuth(UserAuth auth);
    UserAuth findUserAuthbyName(String au_username);
    boolean findUserAuthByid(Integer id);
}
