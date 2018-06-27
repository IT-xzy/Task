import com.pojo.User;
import com.service.UserDaoService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserDaoService {
    private ApplicationContext applicationContext;

    @Before
    public void setApplicationContext() {
        applicationContext =
                new ClassPathXmlApplicationContext("spring/applicationContext.xml");
    }

    @Test
    public void testFindUserById() throws Exception {
        UserDaoService userDaoService = applicationContext.getBean(UserDaoService.class);
        userDaoService.findUserById(1);
    }

    @Test
    public void testFindUserByName() throws Exception {
        UserDaoService userDaoService = applicationContext.getBean(UserDaoService.class);
        userDaoService.findUserByName("万");
    }

    @Test
    public void testFindUserByNumber() throws Exception {
        UserDaoService userDaoService = applicationContext.getBean(UserDaoService.class);
        userDaoService.findUserByNumber("334");
    }

    @Test
    public void testFindUsers() throws Exception {
        UserDaoService userDaoService = applicationContext.getBean(UserDaoService.class);
        userDaoService.findUsers();
    }

    @Test
    public void testInsertUser() throws Exception {
        UserDaoService userDaoService = applicationContext.getBean(UserDaoService.class);
        User user = new User();
        Long time = System.currentTimeMillis();
//        user.setId(1);
        user.setName("晋首席");
        user.setNumber("343455666");
        user.setCreate_at(time);
        user.setUpdate_at(time);
        System.out.println(userDaoService.insertUser(user));
    }

    @Test
    public void testDeleteUser() throws Exception {
        UserDaoService userDaoService = applicationContext.getBean(UserDaoService.class);
        userDaoService.deleteUser(2);
    }

    @Test
    public void testUpdateUser() throws Exception {
        UserDaoService userDaoService = applicationContext.getBean(UserDaoService.class);
        User user = new User();
        Long time = System.currentTimeMillis();
        user.setId(2);
        user.setName("补俊");
        user.setNumber("246456");
        user.setUpdate_at(time);
        userDaoService.updateUser(user);
    }
    @Test
    public void testFindAdministrator() throws Exception {
        UserDaoService userDaoService = applicationContext.getBean(UserDaoService.class);
        System.out.println(userDaoService.findAdministrator("宋武","123456"));
    }
}
