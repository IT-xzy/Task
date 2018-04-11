package com.task.service;

import com.task.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

public interface PersonService {
    //增加并查找
     List<Person> addAndList(Person person, Map map) throws Exception;
   //删除并查找
     List<Person> DeleteAndList(int id,Map map)throws Exception;
    //更新并查找
     List<Person> updateAndList(Person person, Map map) throws Exception;
    //查询
     List<Person> justList(Map map) throws Exception;
    //增加并返回主键确认增加成功
     int justAdd(Person person)throws Exception;
    //删除
     Boolean justDelete(int id)throws Exception;
    //更新
     Boolean justUpdate(Person person)throws Exception;
     //清空数据并重置主键
    Boolean deleteAll();
}


