import com.suger.pojo.User;
import com.suger.service.UserService;
import com.suger.util.DataUtils;
import com.suger.util.MD5Utils;
import com.suger.util.UUIDUtils;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


/**
 * @author suger
 * @date 2018/11/20 16:33
 */
public class UserServiceTest {

    ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-mybatis.xml");
    UserService userService = ctx.getBean(UserService.class);
    static Logger log = Logger.getLogger(UserServiceTest.class);
    @Test
    public void insertUser() throws Exception {
        for(int i= 0;i<1;i++) {
            User user = new User();
            user.setName(DataUtils.getName());
            user.setPwd(DataUtils.getNumber(4));
            log.info("明文密码："+user.getPwd());
            // 获取盐值
            String salt = UUIDUtils.getUUID();
            user.setSalt(salt);
            String password = MD5Utils.md5(user.getPwd()+salt);
            user.setPwd(password);
            user.setCreateAt(DataUtils.getTime());
            user.setUpdateAt(DataUtils.getTime());
            long id = userService.insertUser(user);
            log.info(id);
        }
    }

    @Test
    public void updateUser() throws Exception {
        User user =  new User();
        user.setId(4L);
        user.setPwd(DataUtils.getNumber(4));
        log.info("明文密码："+user.getPwd());
        // 获取盐值
        String salt = UUIDUtils.getUUID();
        user.setSalt(salt);
        String password = MD5Utils.md5(user.getPwd()+salt);
        user.setPwd(password);
        user.setUpdateAt(DataUtils.getTime());
        log.info("修改的信息："+user);
        log.info("修改："+userService.updateUser(user));
    }

    @Test
    public void deleteUser() throws Exception {
        long id = 5L;
        log.info("删除："+userService.deleteUser(id));
    }

    @Test
    public void findAll() throws Exception {
        List<User> users = userService.findAll();
        if(users==null || users.isEmpty()){
            log.info("users列表为空");
        }else{
            log.info("查询："+userService.findAll());
        }
    }

    @Test
    public void total() throws Exception {
        log.info("user的总记录数："+userService.total());
    }

    @Test
    public void getUserById() throws Exception {
        long id = 2;
        log.info("-----根据ID 查询：------");
        userService.getUserById(id);
    }

    @Test
    public void getUser() throws Exception {
        String name = "zql";
        log.info(userService.getUser(name));

        log.info("--------------------------");

        User user = userService.getUserByName(name);
        System.out.println("user.getPwd() = " + user.getPwd());
      /*  if(user==null){
            log.info("此用户不存在");
        }else{
            log.info("根据姓名查询："+userService.getUserByName(name));
        }*/
    }

}