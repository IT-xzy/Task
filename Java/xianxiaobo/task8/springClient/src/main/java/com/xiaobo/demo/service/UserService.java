package com.xiaobo.demo.service;

import com.xiaobo.demo.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public User selectByPrimaryKey(Integer id);
    public List<User> getAllUser(Integer page, Integer size);
}
