package com.Impl;

import com.POJO.User;
import com.Utils.CookieUtil;
import com.Utils.JwtUtil;
import com.Utils.MessageDigestUtil;
import com.Utils.SaltGenerate;
import com.mappers.LoginMapper;
import com.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author: 曹樾
 * @program: task5-module
 * @description: 登录实现类
 * @create: 2018/5/8 下午3:25
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;
    /**
     * 登录请求
     * @param user 页面传入的参数
     * @return 返回一个字符串，判断登录状态。
     */
    
    public String findUser(HttpSession session , HttpServletResponse response, User user) {
        //判断用户名或者密码是否为空
        if (user.getUsername() == null || user.getPassword() == null) {
            return "密码为空";
        }
        
        //根据输入的用户名查找用户信息
        User checkUser = loginMapper.findUserByname(user.getUsername());
        if(null == checkUser){
            return  "信息错误";
        }
        //获得该用户的盐值
        String salt = checkUser.getSalt();
        //再次生成des加密后的密码
        String checkDesPwd = MessageDigestUtil.SHA256(user.getPassword()+salt);
        
        
        if (!checkDesPwd.equals(checkUser.getDesPassword()) ) {
            return "信息错误";
        }
        
        //登录成功，使用工具类生成TOKEN;
        String token = JwtUtil.generateToken("mysignkey1", user.getUsername());
        //将生成的token,放入制定域对象的cookie中，并设置有效时长。
        CookieUtil.createCookie(response, "JWT_COOKIE", token, 30 * 60);
        //生成session
        session.setAttribute("username",user.getUsername());
        session.setMaxInactiveInterval(30*60);
        return "登陆成功";
    }
    public String findUserByName(String username) {
        User user = loginMapper.findUserByname(username);
        return user.getUsername();
    }
    
    
    
    /**
     * 注册请求
     * @param record 页面回传的注册信息
     * @param RecordPassWord
     * @return
     */
   
    public String siginUser(User record, String RecordPassWord) {
        //判断是否存在相同用户信息
        User userFinder = loginMapper.findUserByname(record.getUsername());
        if (userFinder != null) {
            return "注册失败";
        }
        //生成注册用户的盐值
        String salt = SaltGenerate.getSalt();
        record.setSalt(salt);
        //将盐值混入密码中
        StringBuffer hex = new StringBuffer();
        hex.append(record.getPassword()).append(salt);
        String message = hex.toString();
        //des加密
        String desPwd = MessageDigestUtil.SHA256(message);
        //存入record中
        record.setDesPassword(desPwd);
        //清除密码记录（后面直接将表里面的字段删掉）
        record.setPassword("");
        //执行判断语句并判断插入是否成功
        int result = loginMapper.insertSelective(record);
        if (result == 0) {
            return "注册失败";
        }
        
        return "注册成功";
    }
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }
    
    @Override
    public int insert(User record) {
        return 0;
    }
    
    @Override
    public int insertSelective(User record) {
        return 0;
    }
    
    @Override
    public User selectByPrimaryKey(Integer id) {
        return null;
    }
    
    @Override
    public int updateByPrimaryKeySelective(User record) {
        return 0;
    }
    
    @Override
    public int updateByPrimaryKey(User record) {
        return 0;
    }
    
    @Override
    public User selectByUser(User user) {
        return null;
    }
    
    @Override
    public User findUserByname(String name) {
        return null;
    }
}
