package com.ptt.service.impl;

import com.ptt.mapper.UserMapper;
import com.ptt.pojo.User;
import com.ptt.service.IUserService;
import com.ptt.util.CookieUtil;
import com.ptt.util.DESUtil;
import com.ptt.util.Md5Util;
import com.ptt.util.MemcacheUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @ClassName: IUserServiceImpl
 * @Description:
 * @Author: Jin
 * @CreateDate: 2018/5/31 13:37
 * @Version: 1.0
 */
@Service
public class IUserServiceImpl implements IUserService {
    @Value("${cookieName}")
    private String cookieName;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MemcacheUtil memcacheUtil;
    private Logger logger = Logger.getLogger(IUserService.class);

    @Override
    public String register(User user) {
        try {
            if(memcacheUtil.exist(user.getName()) || userMapper.selectByName(user.getName()) != null){
                return "fail";
            }
            user.setPassword(Md5Util.encrypt(user.getPassword()));
            user.setCreateAt(System.currentTimeMillis());
            userMapper.insertSelective(user);
            memcacheUtil.add(user.getName(), user.getName());
            logger.info("注册成功");
            return "success";
        } catch (Exception e) {
            logger.info("注册失败。");
        }
        return "exception";
    }

    @Override
    public User selectByName(String name) {
        return userMapper.selectByName(name);
    }

    @Override
    public boolean login(HttpServletResponse response, User user, String rememberMe, HttpSession session) {
        boolean flag = false;
        //判断输入的用户名和密码不为空
        logger.info("判断用户名和密码是否为空");
        if (StringUtils.isNotBlank(user.getName()) && StringUtils.isNotBlank(user.getPassword())) {
            logger.info("用户名、密码不为空");
            //根据输入从数据库查询出用户详细信息
            String passwordGet = Md5Util.encrypt(user.getPassword());
            user.setPassword(passwordGet);
            if(memcacheUtil.exist(user.getName())){
                session.setAttribute("user", (User)memcacheUtil.getValue(user.getName()));
                memcacheUtil.update(user.getName(), user);
                flag = true;
                if(null != rememberMe){
                    String cookieValue = DESUtil.encrypt(user.getName() + "-" + System.currentTimeMillis());
                    CookieUtil.addCookie(response, cookieName, cookieValue);
                    return flag;
                }
            }
            User result = userMapper.selectByUser(user);
            if (null != result) {
                session.setAttribute("user", result);
                memcacheUtil.add(result.getName(), result);
                flag = true;
                if (null != rememberMe) {
                    String cookieValue = DESUtil.encrypt(user.getName() + "-" + System.currentTimeMillis());
                    CookieUtil.addCookie(response, cookieName, cookieValue);
                    return flag;
                }
            }
/*            User result = userMapper.selectByUser(user);
            if (null != result) {
                session.setAttribute("user", result);
                flag = true;
                if (null != rememberMe) {
                    String cookieValue = DESUtil.encrypt(user.getName() + "-" + System.currentTimeMillis());
                    CookieUtil.addCookie(response, cookieName, cookieValue);
                }
            }*/
        }
        return flag;
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        //根据请求查询到用户详情
        User user = (User) request.getSession().getAttribute("user");
        request.getSession().removeAttribute("user");
        //删除cookie
        CookieUtil.deleteCookie(request, response, cookieName);
    }
}
