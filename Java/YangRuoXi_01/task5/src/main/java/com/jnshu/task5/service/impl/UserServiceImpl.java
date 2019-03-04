package com.jnshu.task5.service.impl;

import com.jnshu.task5.beans.User;
import com.jnshu.task5.mapper.UserMapper;
import com.jnshu.task5.service.UserService;
import com.jnshu.task5.utils.RedisClientUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public List<User> selectAllUser() {
        List<User> userList = userMapper.selectAllUser();
        return userList;
    }

    @Override
    public User selectUserById(Integer id) {
        User user = userMapper.selectUserById(id);
        return user;
    }

    @Override
    public int updateUserById(Integer id, User user) {
        int flag = userMapper.updateUserById(id, user);
        return flag;
    }

    @Override
    public int delectUserById(Integer id) {
        int flag = userMapper.delectUserById(id);
        return flag;
    }

    @Override
    public List selectUserBysalaryDESC() {

//        Jedis jedis = new Jedis();
//        List<String> userListCache = jedis.lrange("userListCache", 0, -1);
//        List<User> userList;
//        if (userListCache == null || userListCache.size() == 0){
//            userList = userMapper.selectUserBySalaryDESC();
//            for (int i = 0; i < userList.size(); i++) {
//                String user = String.valueOf(userList.get(i));
//                jedis.lpush("userListCache",user);
//            }
//            userListCache = jedis.lrange("userListCache",0,-1);
//            return userListCache;
//        }
//        return userListCache;
        //return userMapper.selectUserBySalaryDESC();

        //查询redis中的数据
//        List<User> userList;
//        JedisUtil jedis = JedisUtil.getInstance();
//        boolean isUserList = jedis.HASH.hexists("user", "userList");
//        if (isUserList){
//            String userJson = jedis.HASH.hget("user","userList");
//            userList = FastJsonUtil.getArrayJson(userJson, User.class);
//            return userList;
//        }
//
//        //查询数据库中的数据
//        userList = userMapper.selectUserBySalaryDESC();
//        jedis.HASH.hset("user","userList",FastJsonUtil.toJSONString(userList));
//        return  userList;

        List<User> userListCache = (List<User>) RedisClientUtil.getList("userListCache");
        if (userListCache != null && userListCache.size() != 0){
            return userListCache;
        }

        List<User> userList = userMapper.selectUserBySalaryDESC();
        RedisClientUtil.setList("userListCache",userList);
        return userList;
    }
}
