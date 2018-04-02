package com.task.dao;

import com.task.model.Person;

import java.util.List;

public interface IPersonDao {
    void addPerson(Person person);
    int updatePerson(Person person);
    int deletePerson(int id);
    List<Person> selectAll();
    Person selectById(int id);
    Person selectByName(String name);
    void  deleteAll();
}
