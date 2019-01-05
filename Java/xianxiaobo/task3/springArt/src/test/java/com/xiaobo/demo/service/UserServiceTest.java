package com.xiaobo.demo.service;

import com.xiaobo.demo.pojo.Collection;
import com.xiaobo.demo.pojo.Login;
import com.xiaobo.demo.pojo.User;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
//@ContextConfiguration("classpath:spring/applicationContext.xml")
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml", "classpath:spring/dispatcher-servlet.xml" })
public class UserServiceTest {
    private static Logger log = Logger.getLogger(UserServiceTest.class);
//    ApplicationContext ac =  new ClassPathXmlApplicationContext("classpath:spring/dispatcher-servlet.xml");
//    LoginService loginService =(LoginService) ac.getBean("LoginService");
    @Autowired
    private UserService userService;
    @Autowired
    private LoginService loginService;
    @Autowired
    private CollectionService collectionService;
    @Test
    public void testGetList(){
        User user = new User();
        user.setId(new Long(6));
        Map<String,Object> pageData = new HashMap<>();
        pageData.put("offset",0);
        pageData.put("limit",1000000);
        List<User> userList = userService.getList(user,pageData);
        log.info(userList);
        log.info(userList);
        log.info(userList);
        log.info(userList);
    }
    @Test
    public void testGetCollectionList(){
        // 查询数据
        Collection collection = new Collection();
        Map<String,Object> pageData = new HashMap<>();
        pageData.put("offset",0);
        pageData.put("limit",1000000);
        List<Collection> collectionList = collectionService.getList(collection,pageData);
        ArrayList usernameList = new ArrayList();
        for(Collection collectionItem:collectionList){
            Long id = collectionItem.getUpdate_by();
            log.info(id);
            User user = new User();
            user.setId(id);
            List<User> userList = userService.getList(user,pageData);
            if(userList != null&&userList.size()>=1){
                usernameList.add(userList.get(0).getUsername());
            }
        }
        log.info(usernameList);
    }
    @Test
    public void testPostLogin(){
        log.info("test start");
        Login login = new Login();
        login.setUsername("admin");
        login.setPassword("admin");
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String hashedPassword = loginService.getPasswordByUsername(login.getUsername());
        log.info(hashedPassword);
    }

}
