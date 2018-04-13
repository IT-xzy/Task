package com.task.service;

import com.task.model.Person;

import java.util.List;

public interface PersonService {
    void add(Person person);
    int update(Person person);
    int delete(int id);
    List<Person> listAll();
    Person selectId(int id);
    Person selectName(String name);
    void  clear();
}
