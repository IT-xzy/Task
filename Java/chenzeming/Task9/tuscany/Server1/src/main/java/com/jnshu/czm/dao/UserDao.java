package com.jnshu.czm.dao;

import com.jnshu.czm.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;


@Repository
public interface UserDao {

    boolean deleteUserById(Integer id);//删除用户

    void insertUser(User user);//插入用户

    User findUserById(Integer id);  //通过id查询

    boolean updateUser(User user);//更改用户

    List<User> findAll();//查询全部用户

    int selectCount();//查询用户记录总数

    List<User> findByPage(HashMap<String, Object> map);//分页查询

    int updateByPrimaryKeySelective(User record);

    int insertSelective(User record);


}