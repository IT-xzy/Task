package com.ptteng.dao;

import com.ptteng.entity.User;
import com.ptteng.entity.UserLogin;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapperLogin {
    UserLogin selectUserLogin(String name);
    public void insertUserLogin(UserLogin user);
}
