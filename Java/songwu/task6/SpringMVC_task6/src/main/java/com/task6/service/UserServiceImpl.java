package com.task6.service;

import com.task6.mapper.UserMapper;
import com.task6.pojo.User;
import com.task6.util.RedisUtil;
import net.rubyeye.xmemcached.MemcachedClient;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService {
    Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Autowired
   private UserMapper userMapper;
    @Autowired
    private MemcachedClient memcachedClient;

    @Autowired
    private RedisUtil redisUtil;

    public UserServiceImpl() {
        super();
    }

    @Override
    public List<User> selectAll() {

            List<User> userList = (List<User>) redisUtil.get("userList");
            if (userList == null) {
                List<User> list=userMapper.selectAll();
                redisUtil.set("userList", list, 60 * 1000L);
                logger.info("数据库中取数据");
                return list;
            }
            logger.info("缓存中取数据");
            return userList;
    }



    @Override
    //    动态修改
    public boolean updateUser(User user) {
        if (redisUtil.get("userList") != null) {
            redisUtil.remove("userList");
        }
        return userMapper.updateUser(user);
    }
}
