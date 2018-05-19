package dao;

import org.springframework.stereotype.Repository;
import pojo.User;

@Repository
public interface UserMapper {
    User selectName(String name);
    void insertUser(User user);

}
