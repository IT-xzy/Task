package task8_service.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import task8_service.pojo.User;
import task8_service.util.MD5Utils;

import javax.annotation.Resource;

@ContextConfiguration(locations = "classpath:spring-servlet.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {
    @Resource(name = "userService-2")
    private UserService userService;

    @Test
    public void register() {
        User user =new User();
        user.setUserID(1);
        user.setUserName("唐海清");
        user.setAge(22);
        user.setAdminCode("1686565");
        user.setPassword(MD5Utils.getSaltMD5("123654"));
        user.setTelephone("17688432366");
        user.setEmailaccount("1015320765@qq.com");
        user.setCreatTime(System.currentTimeMillis());
        System.out.println(userService.register(user));

    }

    @Test
    public void loginCheck() {
        System.out.println(userService.loginCheck("1015320765", "1456987"));
    }
}