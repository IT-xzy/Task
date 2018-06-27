package com.ptteng.service.Impl;

import com.ptteng.dao.UserMapper_t11;
import com.ptteng.entity.UserT11;
import com.ptteng.service.UserService_t11;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserServiceImpl_t11 implements UserService_t11 {
    @Autowired
    private UserMapper_t11 userMapper_t11;
    public List<UserT11> getAll2() {
        List userList = this.userMapper_t11.getAll2();
        return userList;
    }
}
