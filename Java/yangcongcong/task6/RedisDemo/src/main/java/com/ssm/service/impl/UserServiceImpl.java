package com.ssm.service.impl;

import com.ssm.dao.UserMapper;
import com.ssm.model.User;
import com.ssm.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Enzo Cotter on 18/4/2.
 */
@Service
public class UserServiceImpl implements UserService {
    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private UserMapper userMapper;

    @Override
    public int addUser(User user) {
        ValueOperations<String, Object> vos = redisTemplate.opsForValue();

        int result = userMapper.addUser(user);
        try {
            if (result == 1) {

                vos.set(String.valueOf(user.getId()), user);
                logger.info("添加的缓存：" + vos.get(String.valueOf(user.getId())));
            } else {
                logger.info("新增数据未成功");
            }
            redisTemplate.delete("userList");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int deleteUser(int id) {
        ValueOperations<String, Object> vos = redisTemplate.opsForValue();

        int result = userMapper.deleteUser(id);
        try {
            if (result == 1) {
                logger.info("删除之前：" + vos.get(String.valueOf(id)));
                if (vos.get(String.valueOf(id)) != null) {
                    redisTemplate.delete(String.valueOf(id));
                    logger.info("删除缓存成功");
                }
                logger.info("不存在改缓存，无需删除");
            } else {
                logger.info("删除数据未成功");
            }
            redisTemplate.delete("userList");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int updateUser(User user) {
        ValueOperations<String, Object> vos = redisTemplate.opsForValue();

        int result = userMapper.updateUser(user);
        try {
            if (result == 1) {
                logger.info("修改之前：" + vos.get(String.valueOf(user.getId())));
                vos.set(String.valueOf(user.getId()), user);
                logger.info("修改之后的缓存：" + vos.get(String.valueOf(user.getId())));
            } else {
                logger.info("修改数据未成功");
            }
            redisTemplate.delete("userList");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public User getById(int id) {
        ValueOperations<String, Object> vos = redisTemplate.opsForValue();

        User user = null;
        try {

            logger.info("判断缓存是否为空字符串"+("".equals(vos.get(String.valueOf(id)))));
            if ("".equals(vos.get(String.valueOf(id)))) {
                logger.info("返回空值");
                return user;
            }

            if (vos.get(String.valueOf(id)) != null) {
                user = (User) vos.get(String.valueOf(id));
                logger.info("读取单个缓存数据>>>" + user);
            } else {
                user = userMapper.getById(id);
                logger.info("查DB得到的数据：" + user);
                if (user != null) {
                    vos.set(String.valueOf(id), user);
                    logger.info("添加缓存数据：" + vos.get(String.valueOf(id)));
                } else {
                    vos.set(String.valueOf(id),"",60,TimeUnit.SECONDS);
                    logger.info("将空值插入缓存，设置短暂过期时间");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> getAll() {
        ValueOperations<String, Object> vos = redisTemplate.opsForValue();

        List<User> userList = null;
        try {
            if (vos.get("userList") != null) {
                userList = (List<User>) vos.get("userList");
                logger.info("读取所有用户的缓存》》》" + userList);
            } else {
                userList = userMapper.getAll();
                vos.set("userList", userList);
                logger.info("从数据库中读取数据》》》" + vos.get("userList"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public List<User> getAllNoMemcached() {
        List<User> userList = userMapper.getAll();
        return userList;
    }
}
