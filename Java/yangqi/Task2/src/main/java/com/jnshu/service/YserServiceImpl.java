package com.jnshu.service;

import com.jnshu.entity.User;
import com.jnshu.model.Userdao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class YserServiceImpl implements YserService {

    @Autowired
    private Userdao userdao;

    @Override
    public List<User> queryName(String user) {
        return userdao.findUserByName(user);
    }

    @Override
    public boolean addUser(User user) {
        return userdao.addUser(user);
    }

    @Override
    public User queryId(int id) {
        return userdao.findUserById(id);
    }

    @Override
    public boolean deleteUser(int id) {
        return userdao.deleteUser(id);
    }

    @Override
    public boolean updateUser(User user) {
        return userdao.updateUser(user);
    }


    @Override
    public boolean updateId(int id, User user) {
        user.setId(id);
        return userdao.updateUser(user);
    }

    @Override
    public List<User> queryUser(User user) {
        return userdao.findUser(user);
    }
}
