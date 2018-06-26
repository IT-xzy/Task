package com.service.Impl;

import com.dao.UserMapper;
import com.entity.User;
import com.service.UserService;

import java.util.List;
import java.util.concurrent.TimeoutException;

import net.rubyeye.xmemcached.XMemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Resource
    private XMemcachedClient memcachedClient;
    private Logger logger = Logger.getLogger("UserServiceImpl");

    public User selectUser(int id) throws InterruptedException, MemcachedException, TimeoutException {
        User user = memcachedClient.get("name" + id);
        User empty;
        if (user == null) {
            logger.info("缓存里没有");
            empty = memcachedClient.get("null" + id);
            if (empty == null) {
                logger.info("空缓存里也没有");
                user = userMapper.selectUser(id);
                if (user == null) {
                    logger.info("数据库没有");
                    memcachedClient.set("null" + id, 60, "不存在的");
                } else {
                    logger.info("数据库里有");
                    memcachedClient.set("name" + id, 3600, user);
                }
            }
        }
        return user;
    }

    public void insertUser(User user) throws InterruptedException, MemcachedException, TimeoutException {
        logger.info("插入时删除缓存");
        memcachedClient.flushAll();
        userMapper.insertUser(user);
    }

    public boolean updateUser(User user) throws InterruptedException, MemcachedException, TimeoutException {
        memcachedClient.flushAll();
        return userMapper.updateUser(user);
    }

    public boolean deleteUser(int id) throws InterruptedException, MemcachedException, TimeoutException {
        memcachedClient.flushAll();
        return userMapper.deleteUser(id);
    }

    public List<User> getAll() throws InterruptedException, MemcachedException, TimeoutException {
        memcachedClient.flushAll();
        List userList = userMapper.getAll();
        return userList;
    }
}

