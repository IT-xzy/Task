
package com.service.Impl;

import com.dao.UserMapper;
import com.entity.User;
import com.service.UserService;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    //@Autowired
    //private RedisTemplate<String, Serializable> redisTemplate;

    @Cacheable("selectUser")
    public User selectUser(int id) {
        System.out.println("lalalal");
        return userMapper.selectUser(id);
    }
    @CacheEvict(value = {"getAll","selectUser"},allEntries = true)
    public void insertUser(User user) {
        userMapper.insertUser(user);
    }
    @CacheEvict(value = {"getAll","selectUser"},allEntries = true)
    public boolean updateUser(User user) {
        return userMapper.updateUser(user);
    }
@CacheEvict(value = {"getAll","selectUser"},allEntries = true)
    public boolean deleteUser(int id) {
        return userMapper.deleteUser(id);
    }
    @Cacheable("getAll")
    public List<User> getAll() {
        System.out.println("dadada");
        List userList = userMapper.getAll();
        return userList;
    }
}

