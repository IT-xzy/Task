package com.service;

import com.dao.UserMapper;
import com.model.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * 实现类
 *
 * @author Administrator
 */
@Service
public class UserServiceImpl implements UserService {

    private Logger logger = Logger.getLogger(UserServiceImpl.class);
    @Resource
    private UserMapper userMapper;

    /**
     * 查找全表
     */
    @Override
    public List<User> findAll()throws Exception {
        return userMapper.findAll();
    }

    /**
     * 模糊查询
     */
    @Override
    public List<User> selectByName(String name)throws Exception {
        return userMapper.selectByName("%" + name + "%");
    }

    /**
     * 条件查询
     */
    @Override
    public List<User> findByCondition(String name, int number) throws Exception{
        return userMapper.findByCondition(name, number);
    }

    /**
     * 通过ID查询
     */
    @Override
    public List<User> findById(long id) throws Exception{
        return userMapper.findById(id);
    }

    /**
     * 增加
     */
    @Override
    public int add(User user) throws Exception{
        return userMapper.add(user);
    }

    /**
     * 删除
     */
    @Override
    public boolean deleteById(Long id)throws Exception {
        boolean flag = false;
        int a = userMapper.deleteById(id);
        try {
            if (a != 0) {
                flag = true;
                logger.info("删除" + flag);
            } else {
                logger.info("删除" + flag);
            }
        } catch (Exception e) {
            logger.info("gg");
        }
        return flag;
    }

    /**
     * 更新
     */
    @Override
    public boolean update(User user) throws Exception{
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
            logger.info("gg");
        }
        return false;
    }
}
