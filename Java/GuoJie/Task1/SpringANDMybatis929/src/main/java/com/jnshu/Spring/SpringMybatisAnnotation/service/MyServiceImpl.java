package com.jnshu.Spring.SpringMybatisAnnotation.service;

import com.jnshu.Spring.SpringMybatisAnnotation.dao.MyDao;
import com.jnshu.Spring.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyServiceImpl implements MyService {
    @Autowired
    private MyDao myDao;

    public User QueryById(int id){
        User user=myDao.QueryById(id);
        return user;
    }
    public void insert(User user){
        myDao.insert(user);
    }
    public void delete(int id){
        myDao.delete(id);
    }
    public void update(User user){
        myDao.update(user);
    }
    public List<User> QueryAll(){
       List<User> user= myDao.QueryAll();
        return user;
    }


}
