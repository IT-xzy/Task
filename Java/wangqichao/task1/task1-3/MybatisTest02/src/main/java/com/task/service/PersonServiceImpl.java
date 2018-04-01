package com.task.service;

import com.task.dao.IPersonDao;
import com.task.dao.PersonDaoImpl;
import com.task.model.Person;

import java.util.List;

public class PersonServiceImpl implements PersonService{
    IPersonDao personDao=new PersonDaoImpl();

    @Override
    public void add(Person person) {
        personDao.addPerson(person);
    }

    @Override
    public int update(Person person) {
        return personDao.updatePerson(person);
    }

    @Override
    public int delete(int id) {
        return personDao.deletePerson(id);
    }

    @Override
    public List<Person> listAll() {
        return personDao.selectAll();
    }

    @Override
    public Person selectId(int id) {
        return personDao.selectById(id);
    }

    @Override
    public Person selectName(String name) {
        return personDao.selectByName(name);
    }

    @Override
    public void clear() {
        personDao.deleteAll();
    }
}
