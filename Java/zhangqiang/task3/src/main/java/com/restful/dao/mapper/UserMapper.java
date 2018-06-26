package com.restful.dao.mapper;

import com.restful.model.Page;
import com.restful.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
@Mapper
public interface UserMapper {


    User findById(int id);

    int findAllCount();

    List<User> findByUser(User user);

    int updateOne(User user);

    int insertOne(User user);

    int deleteOne(int id);

    List<User> findPage(HashMap<String,Object> map);

}
