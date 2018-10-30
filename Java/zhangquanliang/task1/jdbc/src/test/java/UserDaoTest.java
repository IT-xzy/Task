import com.suger.dao.UserDao;
import com.suger.pojo.User;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * jdbc的单元测试
 * @author suger
 * @date 2018-09-12
 */
public class UserDaoTest {

   static Logger log = Logger.getLogger(UserDaoTest.class);
    UserDao userDao = new UserDao();

    @Test
    public void insert(){
        long id = userDao.insert();
        log.info(id);

    }
    @Test
    public void update() {
        User user = new User();
        user.setUserName("张梦");
        long time = System.currentTimeMillis();
        user.setUpdateAt(time);
        user.setUserId(1L);
        log.info(userDao.update(user));
    }

    @Test
    public void delete() {
        log.info(userDao.delete(1L));
    }
    @Test
    public void findAll(){
        List users = userDao.findAll();
        if(users != null) {
            log.info("查询成功");
        }
        ListIterator listIterator = users.listIterator();
        while(listIterator.hasNext()){
            log.info(listIterator.next());
        }
    }
    @Test
    public void getUserByName(){
        List<User> users = new ArrayList<User>();
        String userName = "毛林有";
        log.info("姓名："+userName);
        users = userDao.getUserByName(userName);
        log.info("根据姓名查询"+users);
    }
    @Test
    public void getUserByonlineId(){
        int oId = 81295;
        log.info("学号："+oId);
        log.info("根据学号查询："+userDao.getUserByonlineId(oId));
    }
}
