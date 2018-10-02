import dao.impl.UserDaoImpl;
import jdk.nashorn.internal.runtime.options.LoggingOption;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import pojo.User;
import utils.DataUtils;

import java.util.List;

/**
 * created by suger on 2018/9/13
 */
public class UserDaoImplTest {

    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    UserDaoImpl userDaoImpl = (UserDaoImpl) ctx.getBean("userDaoImpl");
    JdbcTemplate jdbcTemplate = userDaoImpl.getJdbcTemplate();
    static Logger log = Logger.getLogger(UserDaoImplTest.class);

    @Test
    public void insert() throws Exception {
        User user = new User(DataUtils.getName(), DataUtils.getNumber(10), DataUtils.getProfession(),
                DataUtils.getDateTime(), DataUtils.getCollege(), DataUtils.getIntNumber(), DataUtils.getLink(),
                DataUtils.getWish(), DataUtils.getName(), DataUtils.getWay(), DataUtils.getTime(), DataUtils.getTime());
        Long id = userDaoImpl.insert(user);
        log.info(id);
    }
    @Test
    public void update() throws Exception {
        User user1 = new User();
        user1.setUserName(DataUtils.getName());
        user1.setProfession(DataUtils.getProfession());
        user1.setUpdateAt(DataUtils.getTime());
        user1.setUserId(20L);
        Boolean result = userDaoImpl.update(user1);
        log.info(result);
    }
    @Test
    public void delete() throws Exception {
        Long userId = 19L;
        Boolean result = userDaoImpl.delete(userId);
        log.info(result);
    }
    @Test
    public void findAll() throws Exception {
        List users =userDaoImpl.findAll();
        log.info(users);
    }
    @Test
    public void getUserByuserName() throws Exception {
        String name = "金石开";
        List users = userDaoImpl.getUserByName(name);
        log.info(users);
    }
    @Test
    public void getUserByonlineId() throws Exception {
        int onlineId = 1359;
        List users = userDaoImpl.getUserByonlineId(onlineId);
        log.info(users);
    }
}