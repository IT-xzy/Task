package com.fgh.Mybatis.dao;

import com.fgh.Mybatis.model.User;

import java.util.List;

public interface UserMapper {
        public List<User> findUserBy(User user)throws Exception;
        public boolean insertUser(User user)throws Exception;
        public boolean delUser(int id)throws Exception;
        public boolean updateUser(User user)throws Exception;
        public List<User> findAll()throws Exception;
    }
