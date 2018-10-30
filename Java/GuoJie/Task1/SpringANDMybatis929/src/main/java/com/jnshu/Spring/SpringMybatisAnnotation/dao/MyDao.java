package com.jnshu.Spring.SpringMybatisAnnotation.dao;

import com.jnshu.Spring.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyDao {
    public User QueryById(@Param("id")int id);

    List<User> QueryAll();

    public void insert(User user);

    public void delete(int id);

    public void update(User user);
}
