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

    @Override
    public People login(String name, String password) {

        System.out.println("参数" + name+password);

        People people = userMapper.selectByName(name);

        System.out.println(people.toString());
        // 数据存在
        if (people.getName() != null) {
            System.out.println("getname"+people.getPassword());
        // 数据比对
            System.out.println("cacacacacacacaccac"+people.getPassword().equals(password));
            if (people.getPassword().equals(password)) {
                System.out.println("数据库"+people.getPassword());
                System.out.println("密码"+password);
                return people;
            }else {
                System.out.println("lalalalallalalalalal");
            }
        }
        return null;
    }

    @Override
    public People selectByName(String name) {
        return userMapper.selectByName(name);
    }

}
