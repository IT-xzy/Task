package spring.dao;

import spring.model.User;

public interface UserDao {
    User query(User user);
    void add(User user);
    Long getName(String name);
    void reLogin(User user);
    Boolean selectByName(String name);

}
