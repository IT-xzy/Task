package com.ptteng.dao;

import com.ptteng.entity.User;
import com.ptteng.entity.UserLogin;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapperLogin {
    UserLogin selectUserLogin(String name);

    public void insertUserLogin(UserLogin user);

    void insertUserLoginPhoneCode(UserLogin user);

    void insertUserLoginEmailCode(UserLogin user);


    void updateUserLoginImage(UserLogin user);
    UserLogin selectUserLoginById(int id);

}
