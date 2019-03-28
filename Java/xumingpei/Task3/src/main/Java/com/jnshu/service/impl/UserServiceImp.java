package com.jnshu.service.impl;

import com.jnshu.dao.UserMapper;
import com.jnshu.pojo.SecondWork;
import com.jnshu.pojo.User;
import com.jnshu.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pipiretrak
 * @date 2019/3/19 - 9:36
 */
@Service
public class UserServiceImp implements UserService {
    private static Logger logger = Logger.getLogger(UserServiceImp.class);

    @Autowired
    UserMapper userMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        int ID = userMapper.deleteByPrimaryKey(id);
        logger.info("删除的id："+id);
        return ID;
    }

    @Override
    public int insert(User record) {
        int Record = userMapper.insert(record);
        logger.info("插入的数据"+record);
        return Record;
    }

    @Override
    public int insertSelective(User record) {
        int Recond = userMapper.insertSelective(record);
        logger.info("插入的数据"+record);
        return Recond;
    }

    @Override
    public User selectByPrimaryKey(Long id) {
        User user = userMapper.selectByPrimaryKey(id);
        logger.info("查询的ID"+id);
        return user;
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        int Recond = userMapper.updateByPrimaryKeySelective(record);
        logger.info("更新的数据："+record);
        return Recond;
    }

    @Override
    public int updateByPrimaryKey(User record) {
        int Recond = userMapper.updateByPrimaryKey(record);
        logger.info("更新的数据："+record);
        return Recond;
    }

    @Override
    public List<User> selectByDynamic(String name, Long id) {
        List<User> list=userMapper.selectByDynamic(name,id);
        logger.info(list.toString());
        return list;
    }
}
