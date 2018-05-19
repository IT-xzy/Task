package dao;

import pojo.User;

import java.util.Map;

public interface UserMapper {
    void insert(User user) throws Exception;
    User selectbyname(User user);
    User selectbyemail(User user);
    User selectbyphonenumber(User user);
    User login(Map<String, Object> map);
    User selectbyid(Long id);
}
