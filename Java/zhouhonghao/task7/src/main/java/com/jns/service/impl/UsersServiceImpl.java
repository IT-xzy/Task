package com.jns.service.impl;

import com.jns.mapper.UsersMapper;
import com.jns.entity.Users;
import com.jns.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsersServiceImpl implements UsersService {
    //调用dao层的方法，来实现service层接口的方法。

    //@autowired相当于默认的getter()和setter();
    @Autowired
    private UsersMapper usersMapper;
    //抽象类 ，重写
    @Override
    public void add(Users users) {
        usersMapper.add(users);
    }

    @Override
    public void update(Users users) {
        usersMapper.update(users);
    }

    @Override
    public List<Users> list() {
        return usersMapper.list();
    }

    @Override
    public Users getByPhone(String phone) {
        return usersMapper.getByPhone(phone);
    }

    @Override
    public void updateOther(Users users) {
        usersMapper.updateOther(users);
    }

    @Override
    public Users getByName(String name) {
        return usersMapper.getByName(name);
    }

    @Override
    public Users checkLogin(String phone, String password) {
        //根据phone，找到对应的用户
        Users users=usersMapper.getByPhone(phone);
        //判断用户的phone和密码是否正确
        if(users != null && users.getPassword().equals(password)){
            return users;
        }
        return null;
    }
}
