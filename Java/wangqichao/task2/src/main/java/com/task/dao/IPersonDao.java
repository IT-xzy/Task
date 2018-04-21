package com.task.dao;

import com.task.models.Person;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IPersonDao {
    int selectCount();//查询总记录数
    List<Person> listPersonByPage(HashMap<String,Object> map);//根据分页查询数据
    Boolean addPerson(Person person);//添加信息
    Boolean deletePerson(int id);//删除信息
    Boolean updatePerson(Person person);//修改信息
    Person getPerson(int id);//根据id查找
    List<Person> listPersonByName(String name);//根据姓名模糊查找
    List<Person> listPersonById(List list);//一次查询多个id
    List<Person> listAll();//查找全部
    Person getPersonByName(String name);//根据姓名精确查找
    Boolean truncatePerson();//清空表格
}
