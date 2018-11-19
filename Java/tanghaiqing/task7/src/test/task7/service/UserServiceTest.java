package task7.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@ContextConfiguration(locations = "classpath:spring-servlet.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {
    @Resource(name = "userServiceImplImpl")
    private UserService1 userService1;
    @Test
  public void test(){
      userService1.queryUserService(1);
      System.out.println(userService1.queryUserService(1));
  }
}