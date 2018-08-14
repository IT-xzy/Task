package wyq.webapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import wyq.webapp.mapper.UserMapper;
import wyq.webapp.pojo.User;
import wyq.webapp.service.UserService;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void register(User user){
        userMapper.addUser(user);
    }

    @Override
    public User login(String userName, String password){
        return userMapper.findUserByNameAndPwd(userName,password);
    }

    @Override
    public User findUserName(String userName){
        return userMapper.findUserName(userName);
    }

    @Override
    public User getSalt(String userName){
        return userMapper.getSalt(userName);
    }
}
