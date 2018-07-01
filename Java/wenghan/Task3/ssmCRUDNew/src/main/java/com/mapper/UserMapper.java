package com.mapper;

import com.pojo.User;
import java.util.List;

public interface UserMapper {
    //添加一条记录
     int insertUser(User user);
    //根据id删除一条记录
     int deleteUserById(long id);
    //更新一条记录
     int updateUserById(User user);
    //根据id查询一条记录
     User selectUserById(long id);
    //查询全表
     List<User> selectUser();
}
