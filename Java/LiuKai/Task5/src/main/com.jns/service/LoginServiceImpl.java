package service;

import dao.LoginsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Logins;
@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    LoginsDao loginsDao;


    @Override
    public Logins findById(long id) {
        return loginsDao.findById(id);
    }

    @Override
    public boolean addLogin(Logins logins) {
        return loginsDao.addLogin(logins);
    }
}
