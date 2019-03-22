package com.xiaobo.demo.service;

import com.xiaobo.demo.pojo.Login;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LoginService {
    public List<Login> getAll();
    public Login getIdByUsername(String username);
    public Integer checkUsernameExist(String username);
    public Integer postUser(Login login);
    public String getPasswordByUsername(String username);

}
