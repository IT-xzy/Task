package com.suger.service.impl;

import com.suger.dao.UserDao;
import com.suger.pojo.Page;
import com.suger.pojo.Student;
import com.suger.pojo.User;
import com.suger.util.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.suger.service.UserService;

import java.util.List;

/**
 * @author suger
 * @date 2018/11/19 16:12
 * 用户service的实现类
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserDao userDao;
    @Autowired
    RedisUtils redisUtils;
    /**
     * 新增用户信息
     *
     * @param user 用户信息
     * @return
     */
    @Override
    public Long insertUser(User user) {
        Long id = userDao.insertUser(user);
        if(id != null){
            logger.info("新增成功，缓存失效");
            redisUtils.delete("users");
        }
        logger.info("插入Id：{}", id);
        return id;
    }

    /**
     * 更新用户信息
     *
     * @param user
     * @return true-----更新成功，false------更新失败
     */
    @Override
    public Boolean updateUser(User user) {
        boolean flag = false;
        int i = userDao.updateUser(user);
        logger.info("更新id:{}", user.getId());
        logger.info("更新的信息:"+user);

        if (i != 0) {
            logger.info("更新成功，缓存失效");
            redisUtils.delete("users");
            flag = true;
        }
        return flag;
    }

    /**
     * 删除用户信息
     *
     * @param id 用户id
     * @return true-----删除成功，false------更新失败
     */
    @Override
    public Boolean deleteUser(Long id) {
        boolean flag = false;
        logger.info("删除id为：{}的用户", id);
        // 记录将要删除的信息
        logger.info("删除的用户信息:"+userDao.getUserById(id));
        int i = userDao.deleteUser(id);
        if (i != 0) {
            logger.info("删除成功，缓存失效");
            redisUtils.delete("users");
            flag = true;
        }
        return flag;
    }

    /**
     * 分页查询
     *
     * @param page 分页工具类
     * @return
     */
    @Override
    public List<User> findAll(Page page) {
        logger.info("进入分页查询：当前页开始记录："+page.getStart());
        List<User> users;
        if(redisUtils.get("users"+page.getStart())==null){
            logger.info("缓存不存在数据，准备设置缓存");
            users = userDao.findAll();
            redisUtils.set("users"+page.getStart(),users);
        }else {
            logger.info("缓存已经存在,准备读取缓存数据");
            users = (List<User>) redisUtils.get("users"+page.getStart());
        }
        return users;
    }

    /**
     * 查询所有
     *
     * @return
     */
    @Override
    public List<User> findAll() {
        logger.info("---------正在进行查全表------------------");
        List<User> users;
        if(redisUtils.get("users")==null){
            logger.info("缓存不存在数据，准备设置缓存");
            users = userDao.findAll();
            redisUtils.set("users",users);
        }else {
            logger.info("缓存已经存在,准备读取缓存数据");
            users = (List<User>) redisUtils.get("users");
        }
        return users;
    }

    /**
     * 查询记录总数
     *
     * @return 记录总数
     */
    @Override
    public int total() {
        return userDao.total();
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return 具体的用户信息
     */
    @Override
    public User getUserById(Long id) {
        User user = userDao.getUserById(id);
        logger.info("根据id：{}------查询学生：{}", id, user);
        return user;
    }

    /**
     * 根据姓名查询
     *
     * @param name
     * @return
     */
    @Override
    public User getUserByName(String name) {
        return userDao.getUserByName(name);
    }

    /**
     * 根据姓名和id查询，如果条件全为空，则实现查全表
     *
     * @param name
     * @return
     */
    @Override
    public List<User> getUser(String name) {
        if(name==null){
            logger.info("输入姓名为空，正在进行分页查询");
        }
        logger.info("根据姓名模糊查询");
        return userDao.getUser(name);

    }


}
