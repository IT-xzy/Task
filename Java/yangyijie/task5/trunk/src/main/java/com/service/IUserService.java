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
    void insertUser(User user, ModelMap model);
    User loginSelect(User user);
}
