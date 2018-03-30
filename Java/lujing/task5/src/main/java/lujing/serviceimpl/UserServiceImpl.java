package lujing.serviceimpl;

import lujing.Constant;
import lujing.mapper.UserMapper;
import lujing.pojo.User;
import lujing.security.JwtUtils;
import lujing.security.MessageDigestUtils;
import lujing.security.SaltGenerate;
import lujing.service.UserService;
import lujing.util.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author lujing
 * Create_at 2018/1/5 14:45
 */

@Service("userServiceImpl")

public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    
    /**
     * 登录请求
     * @param user 页面传入的参数
     * @return 返回一个字符串，判断登录状态。
     */
    @Override
    public String findUser(HttpSession session ,HttpServletResponse response, User user) {
        //判断用户名或者密码是否为空
        if (user.getName() == null || user.getPassword() == null) {
            return Constant.loginPwdNull;
        }
        
        //根据输入的用户名查找用户信息
        User checkUser = userMapper.findUserByname(user.getName());
        if(null == checkUser){
            return  Constant.loginNameFail;
        }
        //获得该用户的盐值
        String salt = checkUser.getSalt();
        //再次生成des加密后的密码
        String checkDesPwd = MessageDigestUtils.SHA256(user.getPassword()+salt);
        
        
        if (!checkDesPwd.equals(checkUser.getDesPassword()) ) {
            return Constant.loginNameFail;
        }
        
        //登录成功，使用工具类生成TOKEN;
        String token = JwtUtils.generateToken(Constant.siginKey, user.getName());
        //将生成的token,放入制定域对象的cookie中，并设置有效时长。
        CookieUtils.createCookie(response, Constant.jwtCookieName, token, 30 * 60);
        //生成session
        session.setAttribute("username",user.getName());
        session.setMaxInactiveInterval(30*60);
        return Constant.loginSuccess;
    }
    
    @Override
    public String findUserByName(String name) {
        User user = userMapper.findUserByname(name);
        return user.getName();
    }
    
    /**
     * 注册请求
     * @param record 页面回传的注册信息
     * @return
     */
    @Override
    public String siginUser(User record, String RecordPassWord) {
        //判断是否存在相同用户信息
        User userFinder = userMapper.findUserByname(record.getName());
        if (userFinder != null) {
            return Constant.signFail;
        }
        //生成注册用户的盐值
        String salt = SaltGenerate.getSalt();
        record.setSalt(salt);
        //将盐值混入密码中
        StringBuffer hex = new StringBuffer();
        hex.append(record.getPassword()).append(salt);
        String message = hex.toString();
        //des加密
        String desPwd = MessageDigestUtils.SHA256(message);
        //存入record中
        record.setDesPassword(desPwd);
        //清除密码记录（后面直接将表里面的字段删掉）
        record.setPassword("");
        
        //执行判断语句并判断插入是否成功
        int result = userMapper.insertSelective(record);
        if (result == 0) {
            return Constant.signFail;
        }
        
        return Constant.signSuccess;
    }
    
}
