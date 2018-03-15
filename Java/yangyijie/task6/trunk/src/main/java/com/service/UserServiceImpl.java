package com.service;

import com.bean.User;
import com.dao.UserDao;
import com.util.Encrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Arike
 * Create_at 2018/1/6 15:45
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    UserDao userDao;
    
    /**
     * 注册用户的方法
     * @param user 页面传回来的数据
     */
    @Override
    public void insertUser(User user , ModelMap model) {
        user.setCreateAt(System.currentTimeMillis());
        String salt = Encrypt.getSalt();
        String encode = user.getPassWord() + salt;
        encode = Encrypt.getSHA256Str(encode);
        user.setSalt(salt);
        user.setPassWord(encode);
        try {
            userDao.insertUser(user);
        } catch (Exception e) {
            model.addAttribute("intro","用户名已存在");
        }
    
    }
    
    /**
     * 下面2个方法都为验证登陆服务
     * @param user 用户登陆是填写的数据
     * @return 返回根据用户填写的用户名查询的结果,无值的话返回的是null
     */
    @Override
    public User loginSelect(User user) {
        return userDao.loginSelect(user);
    }
    
    /**
     * 验证用户输入的密码是否和数据库中的密码相同
     * @param user 用户登陆填写的数据
     * @param args 接收更多的用以操作的参数, request,response
     * @return 返回值为一个boolean值给controller,用于判断跳转的页面
     */
    public boolean checkLogin(User user, Object... args) {
        User selectUser = loginSelect(user);
        if (selectUser == null) {
            return false;
        } else {
            String checkEocode = Encrypt.getSHA256Str(user.getPassWord() + selectUser.getSalt());
            if (checkEocode.equals(selectUser.getPassWord())) {
                HttpServletResponse response = (HttpServletResponse) args[0];
                HttpSession session = (HttpSession) args[1];
                String code = Encrypt.getSHA256Str(Encrypt.getSalt()).toUpperCase();
                Cookie cookie = new Cookie("key", code);
                cookie.setMaxAge(60 * 60 * 24);
                cookie.setPath("/");
                response.addCookie(cookie);
                session.setAttribute("key", code);
                session.setMaxInactiveInterval(60 * 60 * 24);
                session.setAttribute("name", user.getUserName());
                return true;
            } else {
                return false;
            }
        }
    }
}
