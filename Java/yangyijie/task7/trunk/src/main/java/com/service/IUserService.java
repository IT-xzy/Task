package com.service;

import com.bean.User;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

/**
 * @author Arike
 * Create_at 2018/1/6 15:42
 */
@Service
public interface IUserService {
    //注册用户
    void insertUser(User user, ModelMap model);
    //用户登录
    User loginSelect(User user);
    //更新头像
    void upHead(User user);
    //查询用户
    User selectUser(String userName);
    //更新邮箱验证
    void upEmail(Long id);
    //更新手机验证
    void upPhone(String userName);
}
