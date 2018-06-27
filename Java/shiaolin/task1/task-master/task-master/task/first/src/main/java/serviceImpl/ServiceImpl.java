package serviceImpl;

import com.elements.user.model.User;
import com.elements.user.model.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserService;

@Service("userServiceI")
public class ServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Override
    public User queryUser(int i) {
        return userDao.getUserById(i);
    }

    @Override
    public boolean addUser(User user) {
        return userDao.addUser(user);
    }
    @Override
    public User queryName(User user){
        return userDao.getUserByName(user);
        }

    @Override
    public boolean deleteUser(int i){
        return userDao.deleteUser(i);
    }
    @Override
    public boolean updataUser(User user){
        return userDao.updataUser(user);
    }
}
