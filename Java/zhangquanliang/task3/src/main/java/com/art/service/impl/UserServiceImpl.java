package com.art.service.impl;

import com.art.mapper.UserMapper;
import com.art.pojo.User;
import com.art.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author suger
 * @date 2018/11/6 22:06
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    // 新增用户
    @Override
    public Boolean insert(User record) {
        int result = userMapper.insert(record);
        boolean tag = false;

        if(result==1){
            tag = true;
        }
        return tag;
    }

    // 查询单个用户
    @Override
    public User getUser(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    // 查看用户列表
    @Override
    public List<User> getUser(User record) {
        return userMapper.select();
    }

    // 删除用户
    @Override
    public Boolean delete(Integer id) {
        int result = userMapper.deleteByPrimaryKey(id);

        boolean tag = false;

        if(result==1){
            tag = true;
        }
        return true;
    }
    // 更新用户
    @Override
    public Boolean update(User record) {
        int result = userMapper.updateByPrimaryKeySelective(record);
        boolean tag = false;

        if(result==1){
            tag = true;
        }
        return tag;
    }
}
