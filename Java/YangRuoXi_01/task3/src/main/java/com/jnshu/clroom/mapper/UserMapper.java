package com.jnshu.clroom.mapper;

import com.jnshu.clroom.beans.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

     boolean addUser(User user);

     boolean updateUserById(@Param("userId") Integer userId,  @Param("userName") String userName,
                            @Param("password") String password, @Param("userRole") String userRole);

     User selectUser(Integer id);

     List<User> selectAllUser();

     Boolean delectUserById(Integer userId);


}
