package com.jnshu.mapper;

import com.jnshu.modle.UserAuth;

public interface UserAuthDao {
    boolean userAuth(UserAuth userAuth);
    UserAuth findUserAuthbyName(String au_username);
    boolean findUserAuthByid(Integer id);
}
