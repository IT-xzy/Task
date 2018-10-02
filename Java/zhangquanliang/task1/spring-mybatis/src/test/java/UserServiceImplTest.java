
import com.java.pojo.User;
import com.java.service.UserService;
import com.java.util.DataUtils;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * 基于xml的CRUD 单元测试
 * created by suger on 2018/9/15
 */
public class UserServiceImplTest {

    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    UserService userService = ctx.getBean(UserService.class);
    static Logger log = Logger.getLogger(UserServiceImplTest.class);


    @Test
    public void insert() throws Exception {
        User user = new User();
        user.setUserName(DataUtils.getName());
        user.setQq(DataUtils.getNumber(10));
        user.setProfession(DataUtils.getProfession());
        user.setStartTime(DataUtils.getDateTime());
        user.setGraduatedFrom(DataUtils.getCollege());
        user.setOnlineId(DataUtils.getIntNumber());
        user.setDailyLink(DataUtils.getLink());
        user.setWish(DataUtils.getWish());
        user.setCounselor(DataUtils.getName());
        user.setWay(DataUtils.getWay());
        user.setCreateAt(DataUtils.getTime());
        user.setUpdateAt(DataUtils.getTime());
        log.info("插入前id:"+user.getUserId());
        userService.insert(user);
        log.info("插入后id:"+user.getUserId());

    }

    @Test
    public void update() throws Exception {
        Long time = DataUtils.getTime();
        User user = new User();
        user.setProfession("UI");
        user.setUpdateAt(time);
        user.setUserId(10L);
        log.info(userService.update(user));
    }


    @Test
    public void delete() throws Exception {
        Long userId = new Long(9L);
        Boolean result = userService.delete(userId);
        log.info("删除结果：" + result);
    }

    @Test
    public void findAll() throws Exception {
        List<User> list = userService.findAll();
        log.info("查询全部 " + list);
    }

    @Test
    public void getUserByuserName() throws Exception {
        List list = userService.getUserByName("金石开");
        log.info("查询姓名为金石开的学生： " + list);
    }

    @Test
    public void getUserByonlineId() throws Exception {
        List list= userService.getUserByonlineId(12350);
        log.info("插叙学号为13590的学生：" + list);
    }

}