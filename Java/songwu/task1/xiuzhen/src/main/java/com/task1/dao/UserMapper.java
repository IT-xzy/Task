package com.task1.dao;

import com.task1.pojo.User;

import java.util.List;

public interface UserMapper {
    public long insert(User user);
    public boolean deleteById(long id);
    public  boolean updateById(User user);
    public User selectById(long id);
    public List<User> selectAll();

    public List<User>  selectByOnlineNum(String onlineNum);

    public List<User> selectByName(String name);

    public void insertBatch(List<User> list);
}
