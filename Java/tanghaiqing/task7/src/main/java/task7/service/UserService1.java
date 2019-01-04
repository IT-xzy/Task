package task7.service;

import task7.pojo.User;
import task7.pojo.UserImpl;

public interface UserService1 {
    public UserImpl queryUserService(Integer id);
    public void updateUserService(User user);
}
