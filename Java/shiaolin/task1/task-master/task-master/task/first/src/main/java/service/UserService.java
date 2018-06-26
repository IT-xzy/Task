package service;

import com.elements.user.model.User;
import com.elements.user.model.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public interface UserService {
    User queryUser(int i);
    User queryName(User user);
    boolean addUser(User user);
    boolean updataUser(User user);
    boolean deleteUser(int i);

}
