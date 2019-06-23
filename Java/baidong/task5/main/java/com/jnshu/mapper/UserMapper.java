package com.jnshu.mapper;

import com.jnshu.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    int insert(User user);

    User  selectById(Long id);

    List<User> selectByName(String name);

    List<User> selectByCondition(@Param("name") String name, @Param("password") String password);

}
