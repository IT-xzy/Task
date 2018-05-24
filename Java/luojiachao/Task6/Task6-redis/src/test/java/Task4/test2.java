package Task4;

import Task4.mapper.UserMapper;
import Task4.pojo.User;
import Task4.service.UserService;
import Task4.unit.MemcacheUnit;
import Task4.unit.TokenJWT;
import com.auth0.jwt.interfaces.Claim;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class test2 {
    @Autowired
    private MemcacheUnit memcacheUnit;

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @Test
    public void findByid() throws Exception {

        User user;
        user = userService.findById(1);
        System.out.println(user);

    }
    @Test
    public void TestVerifyToken(){
        try {
            Map<String,Claim> map = TokenJWT.verifyToken("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjM1IiwiZXhwIjoxNTI2OTA0NjA5LCJpYXQiOjE1MjY5MDI4MDl9.ZoqKSKnF9MP1GBJX6l3rypwXg9ytgb7btKhnG1PtoFs");
            System.out.println("id==="+map.get("id").asString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

