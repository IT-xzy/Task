package com.service;

import com.entity.Person;

public interface UserService {
    Person queryId(int i) throws Exception;
    Person queryName(String user) throws Exception;
    boolean addUser(Person person) throws Exception;
    boolean updateUser(Person user) throws Exception;
    boolean deleteUser(int i) throws Exception;
}
