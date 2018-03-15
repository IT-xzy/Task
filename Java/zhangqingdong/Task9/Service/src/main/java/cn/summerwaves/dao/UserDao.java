package cn.summerwaves.dao;

import cn.summerwaves.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    void insertUser(User user);

    List<User> selectIdAvatarUsernameFromAllUser();

    List<User> selectAllUser();

    User selectUserById(int id);

    void updateUser(User user);

    User selectUserByName(String username);
}
