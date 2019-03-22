package com.xiaobo.demo.service;

import com.xiaobo.demo.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface UserService {
    public List<User> getList(User user, Map<String,Object> pageData);
    public Boolean add(User user);
    public Boolean update(User user);
    public Boolean delete(User user);
}
