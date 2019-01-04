package com.xiaobo.demo.dao;

import com.xiaobo.demo.pojo.Login;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginDao {
    public List<Login> getAll();
    public Login getIdByUsername(String username);
    public Integer checkUsernameExist(String username);
    public Integer postUser(Login login);
    public String getPasswordByUsername(String username);
}
