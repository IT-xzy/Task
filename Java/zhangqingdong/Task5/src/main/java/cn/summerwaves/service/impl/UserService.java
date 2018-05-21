package cn.summerwaves.service.impl;

import cn.summerwaves.dao.UserDao;
import cn.summerwaves.model.User;
import cn.summerwaves.service.IUserService;
import cn.summerwaves.util.CookieUtil;
import cn.summerwaves.util.DesUtil;
import cn.summerwaves.util.MD5Util;
import org.springframework.stereotype.Service;
import sun.security.provider.MD5;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@Service
public class UserService implements IUserService {
    @Resource
    private UserDao dao;

    @Override
    public void insertUser(User user) {
        dao.insertUser(user);
    }

    @Override
    public User selectUserByName(String username) {
        return dao.selectUserByName(username);
    }

    @Override
    public String getCookieValueByName(HttpServletRequest request,String name) throws UnsupportedEncodingException {
        return CookieUtil.getCookieValueByName(request,name);
    }

    @Override
    public String setPasswordBySalt(String username, String password) {
        String salt = username.substring(0, username.length() - 1);
        String passwordToMd5 = MD5Util.getMd5(password);
        String finalPassword = MD5Util.getMd5(passwordToMd5 + salt);
        return finalPassword;
    }


}
