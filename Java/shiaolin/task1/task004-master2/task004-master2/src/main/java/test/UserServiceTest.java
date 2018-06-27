package test;

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pojo.User;
import service.UserService;

import javax.jws.soap.SOAPBinding;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-servlet.xml")

public class UserServiceTest {
    @Autowired
    UserService userService;
    @Test
public void testValidateUser() throws Exception {

    System.out.println(userService.validateUser("lin","123456"));
}
@Test
public void testUpdate()throws Exception{
        userService.updateTimeBtId(1);
}

} 
