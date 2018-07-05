package com.jnshu.mapper;

import com.jnshu.model.Auth;

public interface AuthDao {
    //查询用户名与密码是否匹配
    boolean findAuth(Auth auth);
}
