package com.service;

import com.dao.UserMapper;
import com.model.User;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
/**
 * 实现类
 * @author
 * 自动注册到Spring容器
 */
public class UserServiceImpl implements UserService {

    private Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Resource
    private UserMapper userMapper;

    /**
     * 查询全表
     */
    @Override
    public List<User> findAll() throws Exception {
        return userMapper.findAll();
    }

    /**
     * @param name 模糊查询
     * @return
     * @throws Exception
     */
    @Override
    public List<User> selectByName(String name) throws Exception {
        return userMapper.selectByName(name);
    }

    /**
     * 通过ID查询
     */
    @Override
    public List<User> findById(Long id) throws Exception {
        return userMapper.findById(id);
    }

    /**
     * 条件查找
     */
    @Override
    public List<User> getUserByCondition(String name, int number) throws Exception {
        return userMapper.getUserByCondition(name, number);
    }

    /**
     * 条件查找
     */
    @Override
    public int insert(User user) throws Exception {
        return userMapper.insert(user);

    }

    /**
     * 更新
     */
    @Override
    public boolean update(User user) throws Exception {
        boolean flag = false;
        int a = userMapper.update(user);
        try {

            if (a != 0) {
                flag = true;
                logger.info("更新" + flag);

            } else {
                logger.info("更新" + flag);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 删除
     */
    @Override
    public boolean delete(Long id) throws Exception {
        boolean flag = false;
        int a = userMapper.delete(id);
        try {

            if (a != 0) {
                flag = true;
                logger.info("删除" + flag);
            } else {
                logger.info("删除" + flag);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
