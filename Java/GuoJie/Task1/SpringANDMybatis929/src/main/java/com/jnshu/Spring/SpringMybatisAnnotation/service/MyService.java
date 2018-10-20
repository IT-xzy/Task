package com.jnshu.Spring.SpringMybatisAnnotation.service;

import com.jnshu.Spring.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MyService {
    public User QueryById(int id);

    List<User> QueryAll();

    public void insert(User user);

    public void delete(int id);

    public void update(User user);
}
