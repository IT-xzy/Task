
package com.service.Impl;

import com.dao.UserMapper;
import com.entity.User;
import com.entity.User2;
import com.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    public List<User> getAll() {
        List userList = this.userMapper.getAll();
        return userList;
    }


}

