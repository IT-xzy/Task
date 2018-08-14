package com.jnshu.service.impl;

import com.jnshu.dao.UserDAO;
import com.jnshu.entity.User;
import com.jnshu.service.UserService;
import com.jnshu.tools.JedisCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: Tiles
 * @description: Redis缓存
 * @author: Mr.Lee
 * @create: 2018-07-18 00:25
 **/
@Service
public class RedisUserServiceImpl implements UserService {

    private static Logger logger=LoggerFactory.getLogger(RedisUserServiceImpl.class);

    @Autowired
    UserDAO userDAO;

    @Autowired
    JedisCache jedisCache;

    @Override
    public List<User> getAllUser() throws Exception {
        return userDAO.getAllUser();
    }

    @Override
    public User getUserById(int id) throws Exception {
        //find  cache
        Object object = jedisCache.get("user"+id);
        // if exist,return
        if (object!=null){
            return (User)object;
        }
        // if not exist,find user
        User user = userDAO.getUserById(id);
        jedisCache.set("user"+id,user);
        return user;
    }

    @Override
    public List<User> getUserMore(User user) throws Exception {
        return userDAO.getUserMore(user);
    }

    @Override
    public int saveUser(User user) throws Exception {
        //insert and return id
        userDAO.addUser(user);
        //if id exist , delete
        Boolean exist = jedisCache.setStudent("user"+user.getId(),user);
        return user.getId();
    }

    @Override
    public boolean deleteUser(int id) throws Exception {
        jedisCache.delete("user"+id);
        logger.info("delete cache");
        return userDAO.deleteUser(id);
    }

    @Override
    public boolean updateUser(int id, User user) throws Exception {
        Boolean msg = userDAO.updateUser(user);
        String key = "user"+user.getId();
        Object haskey = jedisCache.get(key);
        if (haskey != null){
            //delete old data
            jedisCache.delete(key);
            logger.info("delete cache");
        }
        return msg;
    }
}


