package com.jnshu.serviceimpl;

import com.jnshu.entity.User;
import com.jnshu.mapper.UserMapper;
import com.jnshu.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    Logger logger = Logger.getLogger(UserServiceImpl.class.getName());
    @Autowired
    UserMapper userMapper;
    @Override
    public Boolean register(User user) {
        logger.info("register======="+user.toString());
        boolean flag=false;
        Long uid = userMapper.addOne(user);
        if(uid != 0){
            logger.info("uid======="+uid);
            flag = true;
        }
        return flag;
    }
    @Override
    public Boolean login(User user){
        logger.info("login======="+user.toString());
        Boolean flag = false;
           flag = userMapper.findOne(user);
        return flag;
    }
}
