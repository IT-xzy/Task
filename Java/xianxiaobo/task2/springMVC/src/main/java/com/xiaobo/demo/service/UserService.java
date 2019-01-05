package com.xiaobo.demo.service;
import com.xiaobo.demo.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public List<User> getAll(User user);
    public User getUserById(Integer id);
    public Integer addUser(User user);
    public Boolean deleteUser(Integer id);
    public Boolean updateUser(User user);
}
