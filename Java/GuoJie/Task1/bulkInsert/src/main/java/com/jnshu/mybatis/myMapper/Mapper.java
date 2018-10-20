package com.jnshu.mybatis.myMapper;

import com.jnshu.mybatis.user.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Mapper {
    //根据id查询用户信息
    public User findUserById(int id) throws Exception;
     List<User> findUserList(@Param("idList")List<Integer> idList);
     public void insertUser(User user);
     public void insertList(List<Integer> userList);
}
