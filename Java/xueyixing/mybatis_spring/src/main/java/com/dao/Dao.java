package com.dao;

import com.entity.Person;

public interface Dao {
    boolean addUser (Person person);
    boolean updateUser (Person user);
    boolean deleteUser (int id);
    Person findUserByName (String user);
    Person findUserById (int id);
}
