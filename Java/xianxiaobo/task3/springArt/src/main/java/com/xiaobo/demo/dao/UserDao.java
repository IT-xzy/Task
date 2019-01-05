package com.xiaobo.demo.dao;

import com.xiaobo.demo.pojo.Collection;
import com.xiaobo.demo.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface UserDao {
    public List<User> getList(@Param("user") User user, @Param("pageData") Map<String,Object> pageData);
    public Boolean add(User user);
    public Boolean delete(User user);
    public Boolean update(User user);
}
