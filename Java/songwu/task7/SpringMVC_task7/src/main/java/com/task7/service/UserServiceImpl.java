package com.task7.service;

import com.task7.mapper.UserMapper;
import com.task7.pojo.User;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.concurrent.TimeoutException;

public class UserServiceImpl implements UserService {
    Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Autowired
   private UserMapper userMapper;
    @Autowired
    private MemcachedClient memcachedClient;

    public UserServiceImpl() {
        super();
    }

    @Override
    public List<User> selectAll() {
        try {
            if(memcachedClient.get("UserList")==null){
                List<User> list = userMapper.selectAll();
                memcachedClient.set("UserList",1000*100,list);
                logger.info("缓存中没有，从数据库取数据");

                return list;
            }else{
               List<User> UserList = memcachedClient.get("UserList");
               logger.info("从缓存中取数据");
            return UserList;
            }

        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (MemcachedException e) {
            e.printStackTrace();
        }
        return null;
    }



}
