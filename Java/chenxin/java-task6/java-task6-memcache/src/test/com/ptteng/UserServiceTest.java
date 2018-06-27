package com.ptteng;

import com.ptteng.model.Login;
import com.ptteng.model.User;
import com.ptteng.service.UserService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserServiceTest {

    @Autowired
    UserService userService;
    @Test
    public void testValiateUser() throws Exception{
        Login login = new Login("chenxin","123");
        System.out.println("用户登陆信息："+login.toString());
        System.out.println("用户验证结果："+userService.validateUser(login));
    }
    @Test
    public void testSave() throws Exception{
        User user=new User("q","123");
        System.out.println(userService.register(user));
    }
    @Test
    //测试
    public void testIsExist() throws Exception{
        User user = new User();
        user.setUsername("sss");
        userService.isExist(user);

        System.out.println("测试用户名："+user.getUsername()+"的结果："+userService.isExist(user));

        user.setUsername("chenxin324");
        userService.isExist(user);
        System.out.println("测试用户名："+user.getUsername()+"的结果："+userService.isExist(user));
    }
}
