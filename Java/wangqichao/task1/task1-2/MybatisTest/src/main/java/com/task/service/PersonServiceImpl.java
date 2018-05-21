package com.task.service;

import com.task.dao.IPersonDao;
import com.task.model.Person;
import com.task.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class PersonServiceImpl implements PersonService{
    private SqlSession session;
    private IPersonDao personDao;

    @Override
    public List<Person> addAndList(Person person, Map map) throws Exception {
        session= SqlSessionUtil.getSqlsession();
        personDao=session.getMapper(IPersonDao.class);
        personDao.addPerson(person);
        List<Person> personList=personDao.listPerson(map);
        session.close();
        return personList;
    }

    @Override
    public List<Person> DeleteAndList(int id, Map map) throws Exception {
        session= SqlSessionUtil.getSqlsession();
        personDao=session.getMapper(IPersonDao.class);
        personDao.deletePerson(id);
        List<Person> personList=personDao.listPerson(map);
        session.close();
        return personList;
    }

    @Override
    public List<Person> updateAndList(Person person, Map map) throws Exception {
        session= SqlSessionUtil.getSqlsession();
        personDao=session.getMapper(IPersonDao.class);
       personDao.updatePerson(person);
        List<Person> personList=personDao.listPerson(map);
        session.close();
        return personList;
    }

    @Override
    public List<Person> justList(Map map) throws Exception {
        session= SqlSessionUtil.getSqlsession();
        personDao=session.getMapper(IPersonDao.class);
        List<Person> personList=personDao.listPerson(map);
        session.close();
        return personList;
    }

    @Override
    public int justAdd(Person person) throws Exception {
        session= SqlSessionUtil.getSqlsession();
        personDao=session.getMapper(IPersonDao.class);
        personDao.addPerson(person);
       int id=person.getId();
       session.close();
       return id;
    }

    @Override
    public Boolean justDelete(int id) throws Exception {
        session= SqlSessionUtil.getSqlsession();
        personDao=session.getMapper(IPersonDao.class);
        Boolean bl=personDao.deletePerson(id);
        session.close();
       return bl;
    }

    @Override
    public Boolean justUpdate(Person person) throws Exception {
        session= SqlSessionUtil.getSqlsession();
        personDao=session.getMapper(IPersonDao.class);
        Boolean bl=personDao.updatePerson(person);
        session.close();
        return bl;
    }

    @Override
    public void deleteAll() throws Exception {
        session= SqlSessionUtil.getSqlsession();
        personDao=session.getMapper(IPersonDao.class);
         personDao.truncatePerson();
         session.close();
    }
}
