package cn.Service;
import cn.User.User;

import java.util.List;

public interface UserService {
    User findUserById(int id);
    User insertUser(User user);
    boolean deleteUserId(int id);
    List<User> AllId();
    boolean updateUser(User  user);
    User findName(User user);



}
