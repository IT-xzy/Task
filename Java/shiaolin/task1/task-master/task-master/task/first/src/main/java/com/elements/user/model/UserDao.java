package com.elements.user.model;


public interface UserDao {
    public User getUserById(int i);
    public User getUserByName(User user);
    public boolean addUser(User user);
    public boolean updataUser(User user);
    public boolean deleteUser(int UserId);
}
