package com.aaa.dao.impl;

import com.aaa.dao.UserDAO;
import com.aaa.model.User;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.List;

/** 
* UserDAOImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 8, 2018</pre> 
* @version 1.0 
*/ 
public class UserDAOImplTest {

//@Before
//public void before() throws Exception {
//}
//
//@After
//public void after() throws Exception {
//}

/** 
* 
* Method: insert(User user) 
* 
*/ 
@Test
public void testInsert() throws Exception {
    UserDAO userDAO=new UserDAOImpl();
    User user1 = new User();
    user1.setName("��");
    user1.setPassword("789");
    user1.setBirth("1995.10.5");
    userDAO.insert(user1);
//    �����������
//    User user2 = new User();
//    user2.setName("�������");
//    userDAO.insert(user2);

} 

/** 
* 
* Method: update(User user) 
* 
*/ 
@Test
public void testUpdate() throws Exception {
    UserDAO userDAO=new UserDAOImpl();
    User user = new User();
    user.setId(2735);
    user.setName("��");
    user.setPassword("www");
    user.setBirth("1999.5.2");
    userDAO.update(user);

} 

/** 
* 
* Method: delete(int userId) 
* 
*/ 
@Test
public void testDelete() throws Exception {
    UserDAO userDAO=new UserDAOImpl();
    userDAO.delete(2734);


} 

/** 
* 
* Method: queryById(int userId) 
* 
*/ 
@Test
public void testQueryById() throws Exception { 
UserDAO userDAO=new UserDAOImpl();
   System.out.println(userDAO.queryById(390888));

} 

/** 
* 
* Method: queryAll() 
* 
*/ 
@Test
public void testQueryAll() throws Exception { 
UserDAO userDAO=new UserDAOImpl();
    List<User> list=userDAO.queryAll();
    for (User user : list) {
        System.out.println(user);
    }
}

    @Test
    public void testInsertBatch() {
    long start=System.currentTimeMillis();
    UserDAO userDAO=new UserDAOImpl();
        User user = new User();
        user.setName("����");
        user.setPassword("qaq");
        user.setBirth("2000.1.1");
        userDAO.insertBatch(user);
        long end=System.currentTimeMillis();
        System.out.println(end-start);
    }


} 
