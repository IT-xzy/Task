package com.jnshu.dao;

import com.jnshu.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    int deleteById(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectById(Integer id);

    int updateByIdSelective(User record);

    int updateById(User record);
    int countByName(String name);
}