package com.service;


import com.mapper.UserMapper;
import com.model.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author qmz
 * @Description TODO
 * @Data 2018/7/4$ 18:34$
 **/
@Service
public class UserServiceImpl implements UserService {
@Autowired
private UserMapper userMapper;

    @Override
    public void addUser(People people) {
        userMapper.addUser(people);
    }

    @Override
    public int selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public void job(People people) {
        userMapper.job(people);
    }

    @Override
    public int findJob() {
        return userMapper.findJob();
    }

    @Override
    public People selectPeople(People people) {
        return userMapper.selectPeople(people);
    }

    @Override
    public List<People> listJob() {
        return userMapper.listJob();
    }

}
