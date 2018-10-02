package com.service;


import com.mapper.UserMapper;
import com.model.People;
import com.util.Result;
import com.whalin.MemCached.MemCachedClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;

/**
 * @Author qmz
 * @Description TODO
 * @Data 2018/7/4$ 18:34$
 **/
@Service("userServiceMemImpl")
public class UserServiceMemImpl implements UserService {
    private static Logger logger = Logger.getLogger("UserServiceMemImpl.class");

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MemCachedClient memCachedClient;

    @Override
    public long addUser(People people) {

        //设置用户创建时间
        people.setCreatTime(System.currentTimeMillis());
        Long id=-1L;
        try {
            //添加用户信息
            id=userMapper.addUser(people);
            logger.info("添加用户成功");
            //缓存新增用户信息
            String key = String.valueOf(people.getId());
            memCachedClient.set(key, people);
            logger.info("缓存新增用户信息成功");
        } catch (Exception e) {
            logger.info("添加用户失败");
        }

        return id;
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
        //根据key查询缓存
        String key = String.valueOf(id);
        People people = (People) memCachedClient.get(key);
        //判断缓存是否存在
        if (people != null) {
            logger.info("缓存中有key===" + key);
        } else {
            logger.info("缓存中没有key===" + key);
            //数据库根据id查询用户信息
            people = userMapper.selectById(id);

            //添加缓存
            if(people==null){
                memCachedClient.set(key,-1,new Date(300000));
            }else {
                memCachedClient.set(key, people,new Date(3600000*24+(long) Math.random()*5000));
            }
            logger.info("添加缓存成功，Key===" + key);
        }
        return people;
    }

    @Override
    public int updatePeople(People people) {
        return userMapper.updatePeople(people);
    }

}
