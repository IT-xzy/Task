package com.token.dao;

import com.token.model.UserInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoMapper {
    int add(UserInfo userInfo);

    UserInfo getById(long id);

    UserInfo getByName(String name);
}
