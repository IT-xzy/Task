package com.ssm.service.impl;

import com.alibaba.fastjson.JSON;
import com.ssm.dao.UserMapper;
import com.ssm.model.User;
import com.ssm.service.UserService;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeoutException;

/**
 * Created by Enzo Cotter on 18/4/2.
 */
@Service
public class UserServiceImpl implements UserService {
    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MemcachedClient memcachedClient;

    @Override
    public int addUser(User user) {
        int result = userMapper.addUser(user);
        try {
            if (result == 1) {
                logger.info("正在新增缓存数据>>>");
                memcachedClient.set(String.valueOf(user.getId()), 0, user);
                logger.info("添加的key：："+user.getId());
            }
            boolean userList = memcachedClient.delete("userList");
            logger.info("DELETE THE KEY OF USERLIST :"+userList);
        } catch (TimeoutException | InterruptedException | MemcachedException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int deleteUser(int id) {
        int result = userMapper.deleteUser(id);
        try {
            if (result == 1) {
                boolean delete = memcachedClient.delete(String.valueOf(id));
                logger.info("正在删除缓存>>>"+delete);
            }
            boolean userList = memcachedClient.delete("userList");
            logger.info("DELETE THE KEY OF USERLIST :"+userList);
        } catch (TimeoutException | InterruptedException | MemcachedException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int updateUser(User user) {
        int result = userMapper.updateUser(user);
        try {
            if (result == 1) {
                boolean set = memcachedClient.set(String.valueOf(user.getId()), 0, user);
                logger.info("正在更新缓存>>>"+set);
            }
            boolean userList = memcachedClient.delete("userList");
            logger.info("DELETE THE KEY OF USERLIST :"+userList);
        } catch (TimeoutException | InterruptedException | MemcachedException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public User getById(int id) {
        User user = null;
        try {

            logger.info(""+("".equals(memcachedClient.get(String.valueOf(id)))));
            if ("".equals(memcachedClient.get(String.valueOf(id)))) {
                logger.info("返回空值");
                return user;
            }

            if (memcachedClient.get(String.valueOf(id)) != null) {
                user = memcachedClient.get(String.valueOf(id));
                logger.info("读取单个缓存数据>>>"+user);
            } else {
                logger.info("从数据库取出单个数据>>>");
                user = userMapper.getById(id);
                if (user != null) {
                    boolean set = memcachedClient.set(String.valueOf(id), 0, user);
                    logger.info("添加查出的单个数据缓存>>>" + set);
                } else {
                    memcachedClient.set(String.valueOf(id), 1000,"");
                    logger.info("将空值添加进缓存，设置短暂过期时间"+memcachedClient.get(String.valueOf(id)));
                }
            }
        } catch (TimeoutException | InterruptedException | MemcachedException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> getAll() {
        List<User> userList = null;
        try {
            if (memcachedClient.get("userList") != null) {
                logger.info("从缓存中取出所有用户》》》");
                userList = memcachedClient.get("userList");
            } else {
                logger.info("从数据库中查询所有用户》》》");
                userList = userMapper.getAll();
                boolean set = memcachedClient.set("userList", 0, userList);
                logger.info("添加userList到缓存中》》》"+set);
            }
        } catch (TimeoutException | InterruptedException | MemcachedException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public List<User> getAllNoMemcached() {
        List<User> userList=userMapper.getAll();
        return userList;
    }
}
