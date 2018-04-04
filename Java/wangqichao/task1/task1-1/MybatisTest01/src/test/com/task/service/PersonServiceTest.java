package com.task.service;

import com.task.dao.IPersonDao;
import com.task.model.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import static org.junit.Assert.*;
//生成spring容器
@RunWith(SpringJUnit4ClassRunner.class)
//加载配置文件
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class PersonServiceTest {
      //生成对象注入属性
        @Autowired
         IPersonDao personDao ;
    @Test
    public void addAndList() {
      try {
          for (int i = 0; i < 100; i++){
              Person p = new Person(System.currentTimeMillis(), "xiaojian"+i, 25, "201111");
          personDao.addPerson(p);
      }
          Map<String, Object> parms = new HashMap<>();
          parms.put("name", "xiaojian1");
          List<Person> ps = personDao.listPerson(parms);
          for (Person p1 : ps) {
              System.out.printf("%d\t%s\t%d\t%s%n", p1.getId(), p1.getName(), p1.getAge(), p1.getPersonID());
          }
      }catch(Exception e){
          e.getMessage();
          System.out.println("名称有重复，插入失败");
      }

    }

    @Test
    public void deleteAndList() {
        for(int i=0;i<50;i++) {
            personDao.deletePerson(i);
        }
        Map<String,Object> parms=new HashMap<>();
        parms.put("name","xiaojian9");
        List<Person> ps=personDao.listPerson(parms);
        for(Person p1:ps){
            System.out.printf("%d\t%s\t%d\t%s%n",p1.getId(),p1.getName(),p1.getAge(),p1.getPersonID());
        }
    }

    @Test
    public void updateAndList() {
        Person p=new Person(88,System.currentTimeMillis(),"wangsan",28,"207777");
        personDao.updatePerson(p);
        Map<String,Object> parms=new HashMap<>();
        parms.put("name","wang");
        List<Person> ps=personDao.listPerson(parms);
        for(Person p1:ps){
            System.out.printf("%d\t%s\t%d\t%s%n",p1.getId(),p1.getName(),p1.getAge(),p1.getPersonID());
        }
    }

    @Test
    public void justList() {
        Map<String,Object> parms=new HashMap<>();
        parms.put("name","wang");
        List<Person> ps=personDao.listPerson(parms);
        for(Person p1:ps){
            System.out.printf("%d\t%s\t%d\t%s%n",p1.getId(),p1.getName(),p1.getAge(),p1.getPersonID());
        }
    }

    @Test
    public void justAdd() {
        for (int i = 0; i < 1000000; i++) {
            Person p1 = new Person(System.currentTimeMillis(), "zhangsan"+i, 25, "2015"+i);
            personDao.addPerson(p1);
        //    System.out.println("插入成功，新插入对象id为：" + p1.getId());
        }
    }
    @Test
    public void justDelete() {
        for(int i=50;i<105;i++){
            if(personDao.deletePerson(i)){
                System.out.println("删除成功");
            }
            else
                System.out.println("删除失败");
        }
    }

    @Test
    public void justUpdate() {

            Person p1=new Person(1,System.currentTimeMillis(),"libababab",28,"2011111");

            if(!(personDao.updatePerson(p1))){
                System.out.println("修改失败，无此条信息");
            }

        }
@Test
    public void deleteAll(){
        personDao.truncatePerson();
}
}