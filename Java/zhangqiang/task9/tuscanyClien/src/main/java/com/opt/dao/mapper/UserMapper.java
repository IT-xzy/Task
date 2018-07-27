package com.opt.dao.mapper;

import com.opt.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface UserMapper {


    User findById(int id);

    User findByName(String name);

    User findByPhone(long phone);

    User findByEmail(String email);

    int findAllCount();

    List<User> findByUser(User user);

    int updateOne(User user);

    int insertOne(User user);

    int deleteOne(int id);

    List<User> findPage(HashMap<String, Object> map);

}
