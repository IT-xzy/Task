package com.token.service;

import com.token.model.UserInfo;

public interface UserInfoService {

    int add(UserInfo userInfo);

    UserInfo getById(long id);

    UserInfo getByName(String name);
}
