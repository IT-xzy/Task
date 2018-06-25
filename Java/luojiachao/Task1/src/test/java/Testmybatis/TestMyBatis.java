import mybatis.mapper.UserMapper;
import mybatis.modle.User;
import mybatis.service.UserService;
import org.apache.ibatis.ognl.ParseException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试
@ContextConfiguration(locations={"classpath:applicationContext.xml"}) //加载配置文件
public class TestMyBatis {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserService userService;


        @Test
    public void testfindbyId() throws Exception{
        System.out.println(userService.findById(51));
        }

    @Test
    public void testadd() throws Exception {
        User user = new User("ccc","222222222","222","sjjs","ccc","199","https://ccc","学学学","75654","2222");
        user.setCreate_at(System.currentTimeMillis());
        user.setUpdate_at(System.currentTimeMillis());
        userService.add(user);
        System.out.println("添加成功");
    }
    @Test
    public void delete() throws Exception{
        userService.delete(45);
    }
    @Test
    public void updata() throws Exception{
            User user = new User("ccc","内门","3.27","25","ccc","chuanmei","https://ccc","学学学","75654","2222");
            user.setid(1);
            userService.update(user);
    }
}

