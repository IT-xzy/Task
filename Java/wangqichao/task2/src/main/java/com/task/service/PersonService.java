package com.task.service;

import com.task.models.Page;
import com.task.models.Person;

import java.util.List;
import java.util.Map;

public interface PersonService {
    //增加并查找
     List<Person> addAndList(Person person, String name) throws Exception;
   //删除并查找
     List<Person> DeleteAndList(int id,String name)throws Exception;
    //更新并查找
     List<Person> updateAndList(Person person, String name) throws Exception;
    //通过姓名模糊查询
     List<Person> justList(String name) throws Exception;
     //查询所有
     List<Person> justListAll() throws Exception;
     //按照分页查询
     Page<Person> listByPage(int currentPage);
     //通过id查询
     Person justListById(int id) throws Exception;
     //通过姓名精确查询
     Person justListByName(String name)throws Exception;
    //增加并返回主键确认增加成功
     int justAdd(Person person)throws Exception;
    //删除
     Boolean justDelete(int id)throws Exception;
    //更新
     Boolean justUpdate(Person person)throws Exception;
     //清空数据并重置主键
    Boolean deleteAll();
}


