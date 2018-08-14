package com.task4.service;

import com.task4.mapper.LoginMapper;
import com.task4.pojo.Person;
import com.task4.util.MD5Utils;

import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/** 
* LoginServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>七月 2, 2018</pre> 
* @version 1.0 
*/

@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")

public class PersonServiceImplTest {
@Autowired
LoginService loginService;

@Autowired
LoginMapper loginMapper;


@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: selectLogin() 
* 
*/ 
@Test
public void testSelectLogin() throws Exception {

    System.out.println(loginMapper.selectLogin("宋武"));

}

    @Test
    public void testInsertLogin() {

//        MD5keyBean m = new MD5keyBean();
//        String md5 = m.getkeyBeanofStr("123456");

        MD5Utils md = new MD5Utils();
        String p="12345";
//        String md5 = md.getStrrMD5(p);
        String md5=  md.getStrrMD5(p);
        Person person = new Person("小明", md5);
        System.out.println(loginMapper.insertLogin(person));
    }

    @Test
    public void testLogin() {
        String md5=  MD5Utils.getSaltMD5("123456");
        System.out.println(MD5Utils.getSaltverifyMD5("123456",md5));
    }

    @Test
    public void testUpdateByName() {

        Person person = new Person("宋武", "songwu");
        System.out.println(loginMapper.updateByUsername(person));
    }
}
