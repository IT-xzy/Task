package service.impl;

import dao.UserMapper;
import exception.LoginException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import model.User;
import service.UserService;
import util.CookieUtil;
import util.JwtUtil;
import util.Md5Util;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    private Logger log = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    UserMapper userMapper;
    @Override
    public void addUser(User user) throws Exception {
           userMapper.addUser(user);
    }

    @Override
    public void deleteUserById(String id) throws Exception {
        userMapper.deleteUserById(id);
    }

    @Override
    public User getUserById(String id) throws Exception {
        return userMapper.getUserById(id);
    }

    @Override
    public User getUserByName(String name) throws Exception {
        return userMapper.getUserByName(name);
    }

    @Override
    public User getUser(User user) throws Exception {
        return userMapper.getUser(user);
    }

    @Override
    public void updateUser(User user) throws Exception {
        userMapper.updateUser(user);
    }

    @Override
    public void updatePhoto(User user) throws Exception {
        userMapper.updatePhoto(user);
    }

}
