package com.jnshu.mapper;

import com.jnshu.model.Auth;

/* session登陆验证 已废弃 */
public interface AuthDao {
    //查询用户名与密码是否匹配
    boolean findAuth(Auth auth);
}
