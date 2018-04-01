package com.task.dao;


import com.task.model.Person;
import com.task.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class IPersonDaoTest {
    private SqlSession session;
    private IPersonDao personDao;
    @Before
    public void setup() throws Exception{
        session= SqlSessionUtil.getSqlsession();
        personDao=session.getMapper(IPersonDao.class);
    }

    @Test
    public void addPerson() {
        Person p;
        try {
            for (int i = 0; i < 100; i++) {
                p = new Person(System.currentTimeMillis(), "wangwu" + i, 25, "20111111");
                personDao.addPerson(p);
                //获取插入后的id
                System.out.println("此条信息插入后id为："+p.getId());
            }
        } catch (Exception e) {
            e.getMessage();
            System.out.println("插入姓名有重复，请确认数据");
        } finally {
            session.close();
        }
    }

    @Test
    public void deletePerson() {
       if (personDao.deletePerson(1)){
           System.out.println("删除成功");
       }else{
           System.out.println("删除失败");
        }
       session.close();
    }

    @Test
    public void updatePerson() {
     try {
         Person person = new Person(1, System.currentTimeMillis(), "liyun", 25, "212121");
         if (personDao.updatePerson(person)) {
             System.out.println("修改成功");
         } else {
             System.out.println("修改失败，无此条信息可修改");
         }
     }catch (Exception e){
         e.getMessage();
         System.out.println("修改后的姓名有重复，修改失败");
     }finally {
         session.close();
     }
    }

    @Test
    public void getPerson() {
       try{ Person person=personDao.getPerson(1);
        System.out.println(person);
       }catch (Exception e){
           System.out.println(e.getMessage());
           System.out.println("查无此人");
       }
        finally {
           session.close();
       }
    }

    @Test
    public void listPerson() {
       try {
           Map<String, Object> parms = new HashMap<>();
           parms.put("name", "wang");
           parms.put("id", 50);
           List<Person> personList = personDao.listPerson(parms);
           for (Person p1 : personList) {
               System.out.println(p1);
           }
       }catch (Exception e){
           System.out.println(e.getMessage());
           System.out.println("无此条信息");
       }finally {
           session.close();
       }
    }

    @Test
    //根据多个id查找多个目标
    public void listPersonById() {
       try {
           List<Integer> ids = new ArrayList();
           ids.add(25);
           ids.add(35);
           ids.add(45);
           List<Person> personList = personDao.listPersonById(ids);
           for (Person p1 : personList) {
               System.out.println(p1);
           }
       }catch (Exception e){
           System.out.println(e.getMessage());
           System.out.println("有信息不存在，请确认");
       }finally {
           session.close();
       }
    }

    @Test
    public void truncatePerson() {
        personDao.truncatePerson();
        session.close();
    }
}