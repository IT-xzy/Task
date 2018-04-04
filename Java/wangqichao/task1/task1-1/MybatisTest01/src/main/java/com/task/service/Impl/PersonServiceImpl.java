package com.task.service.Impl;

import com.task.dao.IPersonDao;
import com.task.model.Person;
import com.task.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


public class PersonServiceImpl implements PersonService {
      ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
      IPersonDao personDao=ctx.getBean(IPersonDao.class);


    public IPersonDao getPersonDao() {
        return personDao;
    }

    public void setPersonDao(IPersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    public List<Person> addAndList(Person person, Map map)  {
        personDao.addPerson(person);
        List<Person> list = personDao.listPerson(map);
        return list;
    }
    @Override
    public List<Person> DeleteAndList(int id, Map map)  {
        personDao.deletePerson(id);
        List<Person> list = personDao.listPerson(map);
        return list;
    }
    @Override
    public List<Person> updateAndList(Person person, Map map)  {
        personDao.updatePerson(person);
        List<Person> list = personDao.listPerson(map);
        return list;
    }
    @Override
    public List<Person> justList(Map map)  {
        List<Person> list = personDao.listPerson(map);
        return list;
    }
    @Override
    public int justAdd(Person person)  {
        personDao.addPerson(person);
        return person.getId();
    }
    @Override
    public Boolean justDelete(int id) {
        return   personDao.deletePerson(id);
        }
    @Override
    public Boolean justUpdate(Person person)  {
        return   personDao.updatePerson(person);
        }

    @Override
    public Boolean deleteAll() {
        return personDao.truncatePerson();
    }
}
