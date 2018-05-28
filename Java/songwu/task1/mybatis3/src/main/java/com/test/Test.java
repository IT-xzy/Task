package com.test;

import com.dao.PeopleMapper;
import com.pojo.people;
import com.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

public class Test {
    public static void main(String[] agrs){
SqlSession session=null;
        try {
             session=MybatisUtils.getConnection();

        } catch (IOException e) {
            e.printStackTrace();
        }
        people p=session.selectOne("findPeopleById" ,2);
        System.out.println(p);
people j=new people();
//j.setName("小兰");
//j.setSex("女");
//j.setAddress(423);
        PeopleMapper c=session.getMapper(PeopleMapper.class);
//        c.insertPeople(j);
//        c.deletePeopleById(2);
//        j.setName("静静");
//        j.setId(1);
//        c.updatePeopleById(j);
        List<people> l=session.selectList("findPeopleAll");
        System.out.println(l);
session.commit();

    }
}
