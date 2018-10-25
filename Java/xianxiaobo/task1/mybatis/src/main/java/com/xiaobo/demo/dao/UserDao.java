package com.xiaobo.demo.dao;
import com.xiaobo.demo.dto.User;
import java.util.List;
public interface UserDao {
    User selectUserById(int id) throws Exception;
    List<User> selectUserByName(String name) throws Exception;
    void deleteUserById(int id) throws Exception;
    void insertUser(User user) throws Exception;
    void updateUserById(User user) throws Exception;

}
