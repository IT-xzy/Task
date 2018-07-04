import com.jnshu.zwp.dao.UserDao;
import com.jnshu.zwp.domain.User;
import com.jnshu.zwp.impl.UserDaoImpl;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

public class SqlMyBatisXmlTest {
    private static Logger logger = Logger.getLogger(SqlMyBatisXmlTest.class);
    @Test
    public void testFindUserByID() throws Exception {
        UserDao userDao = new UserDaoImpl();
        User user = userDao.findUserById(12);
        System.out.println(user);
    }

    @Test
    public void testFindAllUser() throws Exception {
        UserDao userDao = new UserDaoImpl();
        List<User> findAllUser = userDao.findAllUsers();
        for (User user2 : findAllUser) {
            System.out.println(user2);
        }
    }

    @Test
    public void testInsertUser() throws Exception {
        UserDao userDao = new UserDaoImpl();
        User user = new User();
        user.setName("吴强东");
        user.setEmp("网络工程师");
        user.setSalary(10000.51);
        userDao.insertUser(user);

    }
    @Test
    public void testDeleteUser() throws Exception{
        UserDao userDao = new UserDaoImpl();
        userDao.deleteUserById(3);
    }

    @Test
    public void testUpdateUser() throws Exception{
        UserDao userDao = new UserDaoImpl();
        User user = new User();
        user.setId(8);
        user.setEmp("销售部总经理");
        user.setSalary(24000.99);
        userDao.updateUserEmp(user);

    }
}
