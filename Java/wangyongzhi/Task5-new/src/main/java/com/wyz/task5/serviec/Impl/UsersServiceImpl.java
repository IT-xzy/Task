package com.wyz.task5.serviec.Impl;

import com.wyz.task5.domain.dao.UsersMapper;
import com.wyz.task5.domain.entity.Users;
import com.wyz.task5.serviec.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersMapper mapper;

    @Override
    public int insert(Users user){
        int result = mapper.insert(user);
        return result;
    }

    @Override
    public int deleteByName(String username){
        int result = mapper.deleteByName(username);
        return result;
    }

    @Override
    public int update(Users user){
        int result = mapper.update(user);
        return result;
    }

    @Override
    public Users getByName(String username){
        Users user = mapper.getByName(username);
        return user;
    }

    @Override
    public int updateloginTime(Users user){
        int result = mapper.updateloginTime(user);
        return result;
    }
}
