package com.task.service;

import com.task.dao.IPersonDao;
import com.task.dao.PersonDaoImpl;
import com.task.model.Person;
import junit.framework.TestCase;

import java.util.List;

public class PersonServiceTest extends TestCase {
    IPersonDao personDao=new PersonDaoImpl();
    public void testAdd() {
        try{for (int i = 0; i < 100; i++) {
            Person person = new Person("libai" + i, 25, "212121");
            personDao.addPerson(person);
              }
            }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("姓名有重复，请确认");
        }
    }

    public void testUpdate() {
        try{for (int i=1;i<105;i++) {
            Person person = new Person(i, "dufu" + i, 25, "2122111");
            if (personDao.updatePerson(person) == 0) {
                System.out.println("修改失败，第"+i+"条信息不存在");
            }
        }
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("姓名已存在，请确认");
        }
    }

    public void testDelete() {
        for (int i=30;i<105;i++){
            if (personDao.deletePerson(i)==0){
                System.out.println("删除失败，第"+i+"条信息不存在");
            }
        }
    }

    public void testListAll() {
        List<Person> personList=personDao.selectAll();
        for(Person p1:personList){
            System.out.println(p1);
        }
    }

    public void testSelectId() {
        try{
            System.out.println( personDao.selectById(2));
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("查无此人，请确认");
        }
    }

    public void testSelectName() {
        try{
            System.out.println(personDao.selectByName("dufu3"));
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("查无此人，请确认");
        }
    }


    public void testClear() {
        personDao.deleteAll();
    }
}