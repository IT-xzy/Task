package com.jnshu.service.impl;

import com.jnshu.mapper.AuthDao;
import com.jnshu.mapper.UserAuthDao;
import com.jnshu.mapper.UserDao;
import com.jnshu.model.*;
import com.jnshu.service.UserService;
import com.jnshu.tools.MemcacheUtils;
import com.jnshu.tools.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: taskTwo
 * @description: Redis缓存接口实现类
 * @author: Mr.xweiba
 * @create: 2018-05-24 19:44
 **/

@Service("userServiceRedisImpl")
public class UserServiceRedisImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Autowired
    AuthDao authDao;
    @Autowired
    UserAuthDao userAuthDao;
    @Autowired
    RedisUtils cacheUtils;

    private static Logger logger = LoggerFactory.getLogger(UserServiceMemcacheImpl.class);

    @Override
    public List<UserCustom> findUserMore(UserQV userQV) throws Exception {
        // logger.info("传入 userQv: " + userQV.toString());
        // 复杂查询 每次数据都不同 不能做缓存 当查询不为空时 执行
        if (userQV.getUserCustom() != null) {
            // logger.info("复杂查询开始");
            return userDao.findUserMore(userQV);
        }
        UserList userList = new UserList();
        Object object = cacheUtils.get("userAll");
        // 当缓存不为空时 直接返回缓存
        if (object != null) {
            logger.info("userALl 缓存输出 ");
            userList = (UserList) object;
            // 直接返回缓存
            return userList.getUserList();
        }
        List<UserCustom> userCustomList = userDao.findUserMore(userQV);
        userList.setUserList(userCustomList);
        /* 当缓存为空时 添加 memcached 缓存 */
        logger.debug("userALl 设置缓存");
        cacheUtils.set("userAll", userList);
        return userCustomList;
    }

    @Override
    public UserCustom findUserById(Integer id) throws Exception {
        // 查找缓存
        Object object = cacheUtils.get("user" + id);
        // 当存在缓存时直接返回缓存数据
        if (object != null) {
            return (UserCustom) object;
        }
        UserCustom userCustom = userDao.findUserById(id);
        // 当缓存为空时 添加 Redis 缓存 注意 为了避免脏读,只有查询的时候才会更新缓存
        cacheUtils.set("user" + id, userCustom);
        return userCustom;
    }

    @Override
    public int insertUser(UserCustom userCustom) throws Exception {
        //插入成功后返回的值存入了user的id中
        userDao.insertUser(userCustom);
        // 写入缓存 这里使用add 当 key(id)存在时, 不写入缓存
        Boolean flag = cacheUtils.set("user" + userCustom.getId(), userCustom);
        // 操作数据后 删除 查询所有信息 的缓存
        if (flag) {
            cacheUtils.expire("userAll", 0);
            logger.info("缓存刷新");
        }
        //所以返回user的id值
        return userCustom.getId();
    }

    @Override
    public boolean updateUser(UserCustom userCustom, Integer id) throws Exception {
        Boolean flagUpdate = userDao.updateUser(userCustom);
        // 操作数据后 删除 查询所有信息 的缓存
        if (flagUpdate) {
            // logger.debug("更新删除中...");
            // 当写入成功时, 让之前的key失效
            cacheUtils.expire("user" + userCustom.getId());
            cacheUtils.expire("userAll");
            logger.info("缓存刷新");
        }
        return flagUpdate;
    }

    @Override
    public boolean deleteUser(Integer i) throws Exception {
        // 删除缓存
        Boolean flag = userDao.deleteUser(i);
        // 操作数据后 删除 查询所有信息 的缓存
        if (flag) {
            // 当写入成功时, 让之前的key失效
            cacheUtils.expire("user" + i, 0);
            cacheUtils.expire("userAll", 0);
            logger.info("缓存刷新");
        }
        return flag;
    }

    /* Session 验证 */
    @Override
    public boolean findAuth(Auth auth) throws Exception {
        // 密码验证的就不做缓存了
        return authDao.findAuth(auth);
    }

    /* Cookie 验证 */
    @Override
    public boolean userAuth(UserAuth userAuth) {
        return userAuthDao.userAuth(userAuth);
    }

    @Override
    public UserAuth findUserAuthByName(String au_username) {
        return userAuthDao.findUserAuthbyName(au_username);
    }

    @Override
    public Boolean findUserAuthByid(Integer id) {
        return userAuthDao.findUserAuthByid(id);
    }
}
