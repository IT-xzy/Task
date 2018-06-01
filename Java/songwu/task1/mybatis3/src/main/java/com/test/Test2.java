package com.test;


import com.dao.PeopleMapper;
import com.pojo.people;
import org.apache.ibatis.io.Resources;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import java.io.IOException;
import java.io.InputStream;

import java.util.List;

public class Test2 {
    private static SqlSessionFactory factory;
    private static InputStream inputStream;
    static {
        try {
            inputStream=Resources.getResourceAsStream("mybatis-config2.xml");
            factory=new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static SqlSessionFactory getSession(){
        return factory;
    }

    public static void main(String[] agrs){
        SqlSession session=getSession().openSession();
        PeopleMapper  m =session.getMapper(PeopleMapper.class);

//        testDelete();
        testFindPeopleById();
//        testFindAll();


        session.commit();
    }
    public static void  testFindPeopleById() {
        SqlSession session = getSession().openSession();
        PeopleMapper m = session.getMapper(PeopleMapper.class);
        people p = m.findPeopleById(30);
        System.out.print(p);

    }

    public   void testDelete(){

        SqlSession session=getSession().openSession();
        PeopleMapper  m=session.getMapper(PeopleMapper.class);
        m.deletePeopleById(10);
//     System.out.print(new Test2().printPeople(testFindAll()));
//     printPeople(testFindAll());


    }
    public  static  List<people> testFindAll() {

        List<people>h = getSession().openSession().selectList("findPeopleAll");
        return h;

    }


    public static void printPeople(List<people> z){
        for(people c:z){
            System.out.print("id："+c.getId());
            System.out.print("name:"+c.getName());
            System.out.print("sex:"+c.getSex());
            System.out.println("address:"+c.getAddress());


        }
    }
}
