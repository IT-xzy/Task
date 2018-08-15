import com.dao.UserDao;
import com.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class TestUserDao {
    @Autowired
    private UserDao userDao;

    @Test
    public void testUpdateUser() throws Exception{
        User user = new User();
        user.setUsername("刘君健");
//        user.setPassword("");
        user.setPhoneNumber("17612135494");
//        user.setMailAddress("w1111dyg@qq.com");
//        user.setHeadURL("sudifgsdfobiandiusnd.asdih");
//        user.setSex("男");
//        user.setAge("266");
        System.out.println(userDao.updateUser(user));
//        System.out.println(userDao.findUserByName("葫芦娃").getAge());
    }
}
