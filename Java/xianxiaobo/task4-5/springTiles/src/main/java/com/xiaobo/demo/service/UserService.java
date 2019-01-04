package com.xiaobo.demo.service;

import com.xiaobo.demo.pojo.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    Boolean insert(User user);
    User getByUsername(User user);
}
