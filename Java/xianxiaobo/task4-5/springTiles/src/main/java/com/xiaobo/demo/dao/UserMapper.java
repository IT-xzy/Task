package com.xiaobo.demo.dao;

import com.xiaobo.demo.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    int insert(User record);
    User getByUsername(User record);
}
