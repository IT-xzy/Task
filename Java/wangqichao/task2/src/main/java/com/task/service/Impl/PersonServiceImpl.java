package com.task.service.Impl;

import com.task.dao.IPersonDao;
import com.task.models.Page;
import com.task.models.Person;
import com.task.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private IPersonDao personDao;


    public IPersonDao getPersonDao() {
        return personDao;
    }

    public void setPersonDao(IPersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    public List<Person> addAndList(Person person, String name)  {
        personDao.addPerson(person);
        List<Person> list = personDao.listPersonByName(name);
        return list;
    }
    @Override
    public List<Person> DeleteAndList(int id, String name)  {
        personDao.deletePerson(id);
        List<Person> list = personDao.listPersonByName(name);
        return list;
    }
    @Override
    public List<Person> updateAndList(Person person, String name)  {
        personDao.updatePerson(person);
        List<Person> list = personDao.listPersonByName(name);
        return list;
    }
    @Override
    public List<Person> justList(String name)  {
        List<Person> list = personDao.listPersonByName(name);
        return list;
    }

    @Override
    public List<Person> justListAll() throws Exception {
        List<Person> list = personDao.listAll();
        return list;
    }
    //按照分页查询
    @Override
    public Page<Person> listByPage(int currentPage) {
        HashMap<String,Object> parms=new HashMap<String, Object>();
        Page<Person> page=new Page<Person>();
        //将形参传入page中
        page.setCurrentPage(currentPage);
        //设置每页显示的数据数量
        int pageSize=15;
        page.setPageSize(pageSize);
        //查询总记录数并传进page
        int totalCount=personDao.selectCount();
        page.setTotalCount(totalCount);
        //计算总页数并传进page
        int totalPage;
        if(totalCount%pageSize==0){
            totalPage=totalCount/pageSize;
        }else {
            totalPage=totalCount/pageSize+1;
        }
          page.setTotalPage(totalPage);
        //设置查询命令开始下标
        parms.put("start",(currentPage-1)*pageSize);
        parms.put("size",pageSize);
        //查询每页数据并封装到page中
        List<Person> lists=personDao.listPersonByPage(parms);
        page.setLists(lists);
        //返回page
        return page;
    }


    @Override
    public Person justListById(int id) throws Exception {
       Person person=personDao.getPerson(id);
        return person;
    }

    @Override
    public Person justListByName(String name) throws Exception {
        Person person=personDao.getPersonByName(name);
        return person;
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
