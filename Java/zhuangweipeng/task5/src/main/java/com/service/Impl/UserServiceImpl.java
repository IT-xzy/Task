
package com.service.Impl;

import com.dao.UserMapper;
import com.entity.Excellent_Stu;
import com.entity.User;
import com.service.UserService;
import com.utils.DesUtil;
import com.utils.Md5Util;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private static final Log log = LogFactory.getLog(UserServiceImpl.class);
    @Resource
    private UserMapper userMapper;

    //登录判断
    @Override
    public boolean judgeUser(String name, String password) throws Exception {
        User user = userMapper.judgeUser(name);
        String DBSaltPassword = user.getPassword();
        String salt = user.getSalt();
        String DBName = user.getName();
        boolean isUserExistence = false;
        //如果加密盐不存在,直接返回验证用户名和密码失败
        if (salt == null) {
            return false;
        } else {
            //加密盐存在，继续查询加密后的密码
            String UserSaltPassword = Md5Util.getSaltMD5(password, salt);
            //比较数据中账户密码和传过来的是否一致
            if (DBSaltPassword.equals(UserSaltPassword) && (DBName.equals(name))) {
                isUserExistence = true;
                log.info("---验证登录成功，UserServiceImpl输出---");
            }
        }
        //log.info("---验证失败，UserServiceImpl输出---");
        return isUserExistence;
    }

    //token生成
    @Override
    public String saveToken(String name) throws Exception {
        User user = userMapper.judgeUser(name);
        //    登录成功，DES加密用户ID和时间
        DesUtil desUtil = new DesUtil("Hello");
        int id = user.getId();
        //    根据id和系统当前时间加密生成token
        String loginToken = desUtil.encrypt(id + "." + System.currentTimeMillis() + "");
        return loginToken;
    }

    //注册加密
    @Override
    public void addUser(User user) {
        //    得到加密盐
        String salt = Md5Util.getSalt();
        //    明文密码
        String oldPassword = user.getPassword();
        //    加盐后的密码
        String saltPassword = Md5Util.getSaltMD5(oldPassword, salt);
        user.setPassword(saltPassword);
        user.setSalt(salt);
        log.info(user);
        userMapper.addUser(user);
    }

    //查询数据库中用户
    @Override
    public User findUserByName(String name) {
        User user = userMapper.findUserByName(name);
        return user;
    }

    //查询数据库展示职业页面
    public List<Excellent_Stu> getAll() {
        List userList = this.userMapper.getAll();
        return userList;
    }

    //查询数据库4条记录显示
    public List<Excellent_Stu> limit() {
        List userList = this.userMapper.limit();
        return userList;
    }


}

