package hzw.mapper;

import hzw.model.User;

import java.util.List;

public interface UserMapper {
    void addUser(User user);

    void deleteUser(Long userId);

    void updateUser(User user);

    User findIdUser(Long userId);

    List<User> findListUser();

    User findNameUser(String userName);
}
