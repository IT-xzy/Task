package userTest;
/**
 * 单元测试
 */

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.pojo.User;
import com.dao.UserDao;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public class UserTest {
    private Logger logger = Logger.getLogger(UserTest.class);
    //1.创建Spring的IOC容器
    //ClassPathXmlApplicationContext是ApplicationContext接口的实现类， 该实现类从类路径下加载配置文件。
    ApplicationContext ctx = new ClassPathXmlApplicationContext("appliactionContext.xml");
    //2.从IOC容器中获取Bean实例
    //获取Bean
    UserDao dao = (UserDao) ctx.getBean("userDao");

    /**
     * 增加的单元测试
     */
    @Test

    public void testAddUser() throws Exception {
        User user = new User();
        user.setCreateAt(new Timestamp(System.currentTimeMillis()));
        user.setUpdateAt(new Timestamp(System.currentTimeMillis()));
        user.setName("FF");
        user.setQq(66);
        user.setJob("爪哇");
        user.setStartTime(55L);
        user.setCollege("复旦");
        user.setNumber(997);
        user.setDailyUrl("com");
        user.setWish("瘦一点");
        user.setBrother("王汇通");
        user.setReferee("加油");
        user.setCity("郑州");
        user.setReview("知乎");
        logger.info(user);
        dao.addUser(user);
    }

    /**
     * 删除的单元测试
     */
    @Test

    public void testDeleteUser() throws Exception {
        dao.deleteUser(18L);
    }

    /**
     * 更新的单元测试
     */
    @Test

    public void testUpdateUser() throws Exception {
        User user = new User();
        user.setId(1L);
        user.setName("zhi");
        user.setQq(123);
        dao.updateUser(user);
    }

    /**
     * 通过ID查询Name的单元测试
     */
    @Test

    public void testSearchUserName() throws Exception {
        String username = dao.searchUserName(1L);
        logger.info(username);
    }

    /**
     * 通过ID查询的单元测试
     */
    @Test

    public void testSearchUser() throws Exception {
        User user = dao.searchUser(4L);
        logger.info(user);
    }

    /**
     * 通过ID和Number查询的单元测试
     */
    @Test

    public void testSearchUserByNameAndNumber() throws Exception {
        User user = dao.searchUserByNameAndNumber("王八蛋", 998);
        logger.info(user);
    }

    /**
     * 模糊查询的单元测试
     */
    @Test

    public void testSearchUserCondition() throws Exception {
        User user = dao.getStudentsByCondition("王");
        logger.info(user);
    }

    /**
     * 查询全表的单元测试
     */
    @Test

    public void itemsList() throws Exception {
        List<Map<String, Object>> users = dao.itemsList();
        logger.info(users);
    }

}