package com.service;


import com.model.People;

import java.util.List;

public interface UserService {
    void addUser(People people);

    int selectAll();

    void job(People people);

    int findJob();

    People selectPeople(People people);

    List<People> listJob();

    public People login(String name,String password);

    People selectByName(String name);

}
