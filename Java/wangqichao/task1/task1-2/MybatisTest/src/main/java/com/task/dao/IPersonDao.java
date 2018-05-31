package com.task.dao;

import com.task.model.Person;

import java.util.List;
import java.util.Map;

public interface IPersonDao {
    int addPerson(Person person);
    Boolean deletePerson(int id);
    Boolean updatePerson(Person person);
    Person getPerson(int id);
    List<Person> listPerson(Map map);
    List<Person> listPersonById(List list);
    Boolean truncatePerson();
}
