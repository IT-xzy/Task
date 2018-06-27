package com.restful.service;

import com.restful.model.Page;
import com.restful.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {


    User findById(int id);

    int findAllCount();

    List<User> findByUser(User user);

    int updateOne(User user);

    int insertOne(User user);

    int deleteOne(int id);

    Page<User> findByPage(int nowpage,int pagesize);


}
