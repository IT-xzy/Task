package com.service.impl;

import com.dao.UserDao;
import com.entity.User;
import com.service.UserService;
import com.util.CookieUtil;
import com.util.DESUtil;
import com.util.DateUtil;
import com.util.MD5Util;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    private Logger logger = Logger.getLogger(UserService.class);

    @Override
    public Boolean register(User user) {
        boolean flag = false;
        try{
            user.setPassword(MD5Util.generate(user.getPassword()));
            user.setCreate_time(System.currentTimeMillis());
            userDao.register(user);
            logger.info("注册成功");
            flag = true;
            return flag;
        }catch (Exception e){
            logger.info("注册失败");
        }
        return flag;
    }

    @Override
    public User login(User user,HttpServletResponse response) {
        logger.info("判断用户名和密码是否为空");
        if (StringUtils.isNotBlank(user.getName()) && StringUtils.isNotBlank(user.getPassword())){
            logger.info("用户名和密码不为空,比对数据库中的加密密码和用户输入的密码是否为同一个字符串");
            boolean flag = MD5Util.verify(user.getPassword(),userDao.findPasswordByName(user.getName()));
            logger.info("验证用户信息");
            if (flag=true){
                String loginTime = DateUtil.dateToYMDHMS(new Date());
                logger.info("已通过验证用户:"+user.getName());
                logger.info("将用户名和登录时间用DES加密,并生成token");
                String token = DESUtil.encode("ytd1129097428",user.getName()+":"+loginTime);
                logger.info("生成的token:"+token);
                CookieUtil.setCookie(response,loginTime,token,CookieUtil.COOKIE_MAX_AGE);
                logger.info("把token放到cookie中,添加cookie,名字是"+user.getName()+",过期时间为"+CookieUtil.COOKIE_MAX_AGE+"秒");
            }else {
                return null;
            }
        }
        logger.info("用户名和密码有误");
        return null;
    }

    @Override
    public void logout(HttpServletResponse response, HttpServletRequest request) {
        //根据请求查询到用户详情
        User user = (User) request.getSession().getAttribute("user");
        //移除session
        request.getSession().removeAttribute("user");
        //移除名为用户名的cookie
        CookieUtil.removeCookie(request,response,user.getName());
    }

    @Override
    public User findByName(String name) {
        return userDao.findByName(name);
    }


    @Override
    public String findPasswordByName(String name) {
        return userDao.findPasswordByName(name);
    }
}

