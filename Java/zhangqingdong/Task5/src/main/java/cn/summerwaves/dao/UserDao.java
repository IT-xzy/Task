package cn.summerwaves.dao;

import cn.summerwaves.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    void insertUser(User user);

    User selectUserByName(String username);
}
