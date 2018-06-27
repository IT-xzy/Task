package service;

import model.User;

import javax.servlet.http.HttpServletResponse;

public interface UserService {
    void addUser(User user) throws Exception;
    void deleteUserById(String id) throws Exception;
    User getUserById(String id) throws Exception;
    User getUserByName(String name) throws Exception;
    User getUser(User user) throws Exception;
    void updateUser(User user) throws Exception;
    void updatePhoto(User user) throws Exception;

}
