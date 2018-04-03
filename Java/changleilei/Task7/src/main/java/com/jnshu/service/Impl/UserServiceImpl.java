package com.jnshu.service.Impl;
import com.jnshu.dao.UserDao;
import com.jnshu.model.User;
import com.jnshu.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public int deleteById(Integer id) {
        return 0;
    }

    @Override
    public int insert(User record) {
        return 0;
    }

    @Override
    public int insertSelective(User record) {
        return 0;
    }

    @Override
    public User selectById(Integer id) {
        return userDao.selectById(id);
    }

    @Override
    public int updateByIdSelective(User record) {
        return userDao.updateByIdSelective(record);
    }

    @Override
    public int updateById(User record) {
        return 0;
    }

    @Override
    public int countByName(String name) {
        return userDao.countByName(name);
    }
}
