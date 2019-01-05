package com.xiaobo.demo.service;

import com.xiaobo.demo.pojo.Login;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class LoginServiceTest {
    private static Logger log = Logger.getLogger(UserServiceTest.class);
    ApplicationContext ac =  new ClassPathXmlApplicationContext("classpath:spring/dispatcher-servlet.xml");
    LoginService loginService =(LoginService) ac.getBean("LoginService");
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
