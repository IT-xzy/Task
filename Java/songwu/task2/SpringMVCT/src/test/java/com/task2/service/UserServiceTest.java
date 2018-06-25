package com.task2.service;

import com.task2.mapper.UserMapper;
import com.task2.pojo.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/** 
* UserService Tester. 
* 
* @author <Authors name> 
* @since <pre>六月 11, 2018</pre> 
* @version 1.0 
*/
//@RunWith(SpringJUnit4ClassRunner.class)

//@ContextConfiguration(locations= "classpath:spring/applicationContext.xml")
//@Component
public class UserServiceTest {
    ApplicationContext applicationContext;
    UserMapper userMapper;

//@Autowired
//UserServiceImpl userServiceImpl;

@Before
public void before()  {
    applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
     userMapper = (UserMapper) applicationContext.getBean("userMapper");
}

//@After
//public void after() throws Exception {
//}

/** 
* 
* Method: findUserCount() 
* 
*/ 
@Test
public void testFindUserCount() throws Exception {
//    UserServiceImpl userServiceImpl = (UserServiceImpl)applicationContext.getBean("userServiceImpl");

    System.out.println(userMapper.findUserCount());

} 


@Test
public void testFindUserByPage() throws Exception {
//    UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");
    System.out.println(userMapper.findUserByPage(2,5));

} 
@Test
    public void testInsertUser() {
    User user=new User();
    user.setName("刘军建");
    user.setQq("ljj");
    user.setType("java");
    userMapper.insertUser(user);
    System.out.println(user.getId());
}

    @Test
    public void testSelectUser() {

   User user=new User();
//   user.setName("刘");
//   user.setType("java");
//   user.setId(20);
        System.out.println(userMapper.selectUser(user));
    }

} 
