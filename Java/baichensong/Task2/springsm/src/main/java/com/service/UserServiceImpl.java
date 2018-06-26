package com.service;

        import com.Dao.UserDao;
        import com.page.Page;
        import com.pojo.User;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private   UserDao userDao;


    @Override // 方法重写  注释。 重写父类方法
    public User findUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public int insertUser(User user) {
        return userDao.getinsertUser(user);

    }

    @Override
    public void deleteUserId(int id) {
        userDao.deleteId(id);
    }

    @Override
    public List<User> AllId() {
        return userDao.findAllId();
    }

    @Override
    public  List<User> AllId(Page page){
        return userDao.findAllId(page);
    }

    @Override
    public void updateUser(User user) {
        userDao.UpdateUser(user);
    }

    @Override
    public List<User> findName(User user){
        return  userDao.findname(user);
    }
    @Override
    public  User get(int id){
        return userDao.getEdit(id);
    }

    @Override
    public int total(){
        return userDao.total();
    }



}
