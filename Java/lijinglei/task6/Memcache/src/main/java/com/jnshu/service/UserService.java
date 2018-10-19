package com.jnshu.service;

import com.jnshu.model.User;

import java.util.List;

public interface UserService {
    String addInfo(User addInfo);

    List<User> getAll();

    String delete(int id);

    User findById(int id);

    String update(User addInfo);

    User login(User user);

    List<User> getPage(int pageNo, int SHOW_ITEMS);

    Integer countAll();

    Integer findByName(String name);

//    List<String> getId(int pageNo, int SHOW_ITEMS);

}
