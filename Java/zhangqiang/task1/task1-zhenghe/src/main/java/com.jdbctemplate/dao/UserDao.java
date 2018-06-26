package com.jdbctemplate.dao;

import com.jdbctemplate.pojo.Person;
import com.jdbctemplate.pojo.User;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public interface UserDao {


    List<User> findAll();

    User selectById(int id);

    void updateUser(User user);

    void delectUser(int id);

    int insertUser(User user);

    void insertList(List<User> list);


    int selectCount();


}
