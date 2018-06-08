package com.fangyuyang.service.serviceImpl;

import com.fangyuyang.dao.UserMapper;
import com.fangyuyang.model.User;
import com.fangyuyang.service.UserService;

import com.fangyuyang.subsidiary.memcache.MemcachedUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Resource
    private MemcachedUtil memcachedUtil;
    public void addUser(User user) {
        userMapper.insert(user);
    }
    public void updateUser(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }
    public void deleteUser(int id) {
        userMapper.deleteByPrimaryKey(id);
    }
    public int countAll() {
        return userMapper.countAll();
    }

    public User findUserById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }
    public User findByName(String name) {
        return userMapper.selectByName(name);
    }
        public Object memCacheGet(String key){
            Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
            Object result = null;
            if(memcachedUtil.get(key)!=null){
  //                logger.info("输出，{}",memcachedUtil.get(key));
//            }
//            if (memcachedUtil.cas(key, 36000, memcachedUtil.get(key))) {
                result = memcachedUtil.get(key);
                logger.info("缓存输出");
            } else {
                logger.info("需要调用数据库");
                memcachedUtil.set(key, userMapper.selectByPrimaryKey(Integer.parseInt(key)), 36000);
                result = memcachedUtil.get(key);
                logger.info("输入后再取出,{}", result);
            }
            return result;

    }

}
