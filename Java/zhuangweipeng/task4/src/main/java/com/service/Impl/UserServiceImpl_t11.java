package com.service.Impl;

import com.dao.UserMapper;
import com.dao.UserMapper_t11;
import com.entity.User2;
import com.service.UserService_t11;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service

public class UserServiceImpl_t11 implements UserService_t11{
    @Resource
    private UserMapper_t11 userMapper_t11;

    //查询所有职业信息
    public List<User2> getAll2() {
        return userMapper_t11.getAll2();
    }
}
