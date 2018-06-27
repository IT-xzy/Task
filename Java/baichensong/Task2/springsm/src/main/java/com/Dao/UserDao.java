package com.Dao;

import com.page.Page;
import com.pojo.User;

import java.util.List;

public interface UserDao {
    public User getUserById(int id);

    public int getinsertUser(User user);

    public void deleteId(int id);
    public List<User> findAllId();
    public List<User> findAllId(Page page);
    public void UpdateUser(User user);
    public List<User> findname(User user);

    public User getEdit(int id);

    public int total();


}
