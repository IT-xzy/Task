package task05.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task05.dao.UserLoginDao;
import task05.pojo.UserLogin;
import task05.services.UserLoginServices;


@Service
public class UserLoginServicesImpl implements UserLoginServices {
    @Autowired
    private UserLoginDao userLoginDao;

    @Override
    public UserLogin login(UserLogin userLogin) {
        return userLoginDao.login(userLogin);
    }

    @Override
    public void register(UserLogin userLogin) {
        userLoginDao.register(userLogin);
    }

    @Override
    public UserLogin queryByName(String name){return userLoginDao.queryByName(name);}

    @Override
    public void insertDes(String s) {
        userLoginDao.insertDes(s);
    }

    @Override
    public void updateDes(String despassword, int id) {
        userLoginDao.updateDes(despassword,id);
    }


}
