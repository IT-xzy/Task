package cn.Service.Impl;
import cn.dao.UserDao;
import cn.User.User;
import cn.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userservice")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override // 方法重写  注释。 重写父类方法
    public User findUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public User insertUser(User user) {
        return userDao.getinsertUser(user);

    }

    @Override
    public boolean deleteUserId(int id) {
        return userDao.deleteId(id);
    }

    @Override
    public List<User> AllId() {
        return userDao.findAllId();
    }

    @Override
    public boolean updateUser(User user) {
        return userDao.UpdateUser(user);
    }

    @Override
    public User findName(User user){
    return  userDao.findname(user);
    }



}
