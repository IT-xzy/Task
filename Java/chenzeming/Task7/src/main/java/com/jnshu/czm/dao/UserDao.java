package com.jnshu.czm.dao;

import com.jnshu.czm.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Repository
public interface UserDao {

    User findUserById(Integer id);  //通过id查询

    List<User> findAll();//查询全部用户

    int selectCount();//查询用户记录总数

}