package com.xiaobo.demo.service;

import com.xiaobo.demo.pojo.User;
import org.springframework.stereotype.Service;

@Service("UserService")
public interface UserService {
    Boolean insert(User user);
    User getByUsername(User user);
    Boolean updateByPrimaryKeySelective(User user);
    User getUser(User user);
    User getUserWithoutPassword(User user);
}
