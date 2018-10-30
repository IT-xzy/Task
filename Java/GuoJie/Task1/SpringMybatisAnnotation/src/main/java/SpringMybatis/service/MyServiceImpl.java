package SpringMybatis.service;

import SpringMybatis.User;
import SpringMybatis.dao.MyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MyServiceImpl  implements MySevice{
    @Autowired
    private MyDao myDao;
    private MySevice mySevice;
    public User findById(int id) {
       User user= myDao.findById(id);
        return user;
    }
    public List<User> findAll(){
        List<User> user=myDao.findAll();
        return user;
    }
    public void insertUser(User user){
        mySevice.insertUser(user);
    }
}
