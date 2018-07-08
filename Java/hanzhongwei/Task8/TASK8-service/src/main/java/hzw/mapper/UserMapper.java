package hzw.mapper;

import hzw.model.User;

import java.util.List;

public interface UserMapper {
    void addUser(User user);

    void deleteUser(Long userId);

    void updateUser(User user);

    void updateUser1(User user);

    User findIdUser(Long userId);

    User findIphone(String userIphone);

    List<User> findListUser();

    User findNameUser(String userName);

    User findCodeUser(String userCode);

    User findMailUser(String userEmail);
}
