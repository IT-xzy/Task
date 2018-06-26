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


@Service("userServiceMemcacheImpl")
public class UserServiceMemcacheImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Autowired
    AuthDao authDao;
    @Autowired
    UserAuthDao userAuthDao;
    @Autowired
    MemcacheUtils memcacheUtils;

    private static Logger logger = LoggerFactory.getLogger(UserServiceMemcacheImpl.class);

    @Override
    public List<UserCustom> findUserMore(UserQV userQV) throws Exception {
        // logger.info("传入 userQv: " + userQV.toString());
        // 复杂查询 每次数据都不同 不能做缓存 当查询不为空时 执行
        if(userQV.getUserCustom() != null){
            // logger.info("复杂查询开始");
            return userDao.findUserMore(userQV);
        }

        UserList userList = new UserList();
        Object object = memcacheUtils.get("userAll");
        // 当缓存不为空时 直接返回缓存
        if (object != null) {
            userList = (UserList) object;
            logger.info("userALl 缓存输出 ");
            // 直接返回缓存
            return userList.getUserList();
        }
        List<UserCustom> userCustomList = userDao.findUserMore(userQV);
        // UserList userList = new UserList();
        userList.setUserList(userCustomList);
        // 当缓存为空时 添加 memcached 缓存
        logger.info("userALl 设置缓存");
        memcacheUtils.set("userAll", userList);
        return userCustomList;
    }

    @Override
    public UserCustom findUserById(Integer id) throws Exception {
        // 查找缓存
        Object object = memcacheUtils.get("user" + id);
        // 当存在缓存时直接返回缓存数据
        if (object != null) {
            logger.info("userId 缓存输出");
            return (UserCustom) object;
        }
        UserCustom userCustom = userDao.findUserById(id);
        // 当缓存为空时 添加 memcached 缓存, 为避免脏读问题,缓存只在读取时添加
        memcacheUtils.set("user" + id, userCustom);
        return userCustom;
    }

    @Override
    public int insertUser(UserCustom userCustom) throws Exception {
        //插入成功后返回的值存入了user的id中
        if(userDao.insertUser(userCustom)>0){
            // 操作数据后 删除 查询所有信息 的缓存
            memcacheUtils.delete("userAll");
            logger.info("缓存刷新");
        }
        //返回user的id值
        return userCustom.getId();
    }

    @Override
    public boolean updateUser(UserCustom userCustom, Integer id) throws Exception {
        Boolean flag = userDao.updateUser(userCustom);

        if(flag){
            // 更新时只删除原缓存, 不设置缓存, 防止脏读
            userCustom.setId(id);
            memcacheUtils.delete("user" + id);
            // 操作数据删除 查询所有信息 的缓存
            // logger.info("userAll is delete");
            memcacheUtils.delete("userAll");
            logger.info("缓存刷新");
        }
        return userDao.updateUser(userCustom);
    }

    @Override
    public boolean deleteUser(Integer i) throws Exception {
        // 删除缓存
        Boolean flag = userDao.deleteUser(i);

        if(flag){
            // 操作数据后 删除 查询所有信息 的缓存
            memcacheUtils.delete("userAll");
            logger.info("userAll 缓存刷新");
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
