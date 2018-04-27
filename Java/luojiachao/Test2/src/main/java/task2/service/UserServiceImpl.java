package task2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task2.mapper.UserMapper;
import task2.pojo.User;

    @Service
    public class UserServiceImpl implements UserService {

        @Autowired
        private UserMapper userMapper;

        @Override
        public void regist(User user) {
            // TODO Auto-generated method stub
            userMapper.addUser(user);
        }

        @Override
        public User login(String username, String password) {
            // TODO Auto-generated method stub
            return  userMapper.findUserByName(username,password);

        }
    }

