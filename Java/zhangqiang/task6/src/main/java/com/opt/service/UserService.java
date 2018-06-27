package com.opt.service;


import com.opt.model.Page;
import com.opt.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {


    User findById(int id);

    User findByName(String name);

    int findAllCount();

    List<User> findByUser(User user);

    int updateOne(User user);

    int insertOne(User user);

    int deleteOne(int id);

    Page<User> findByPage(int nowpage, int pagesize);


}
