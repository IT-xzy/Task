package com.service;
/*
 * @ClassName:UserServiceImpl
 * @Description:TODO
 * @Author qiao
 * @Date 2018/8/17 17:35
 **/

import com.mapper.UserMapper;
import com.model.People;
import com.whalin.MemCached.MemCachedClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import org.apache.log4j.Logger;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {
    private static Logger logger = Logger.getLogger("UserServiceImpl.class");

    @Autowired
    private UserMapper userMapper;

    @Override
    public long addUser(People people) {
        return userMapper.addUser(people);
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

        System.out.println("参数" + name + password);

        People people = userMapper.selectByName(name);

        System.out.println(people.toString());
        // 数据存在
        if (people.getName() != null) {
            System.out.println("getname" + people.getPassword());
            // 数据比对
            logger.info("两次密码对比" + people.getPassword().equals(password));
            if (people.getPassword().equals(password)) {
                logger.info("数据库" + people.getPassword());
                logger.info("密码" + password);
                return people;
            } else {
                logger.info("登陆失败");
            }
        }
        return null;
    }

    @Override
    public People selectByName(String name) {
        return userMapper.selectByName(name);
    }

    @Override
    public People selectById(long id) {
        return userMapper.selectById(id);
    }

    @Override
    public int updatePeople(People people) {
        return userMapper.updatePeople(people);
    }

}