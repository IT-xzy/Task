package com.service;

import com.dao.Dao;
import com.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ServiceI")
public class serviceImpl implements UserService {
    @Autowired
    Dao dao;
    @Override
    public Person queryName(String user) {
        return dao.findUserByName(user);
    }
    @Override
    public boolean addUser(Person person) {
        return dao.addUser(person);
    }
    @Override
    public Person queryId(int id){
        return dao.findUserById(id);
    }
    @Override
    public boolean deleteUser(int id){
        return dao.deleteUser(id);
    }
    @Override
    public boolean updateUser(Person user){
        return dao.updateUser(user);
    }
}
