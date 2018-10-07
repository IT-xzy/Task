import com.java.dao.UserAnnotationDao;
import com.java.pojo.User;
import com.java.util.DataUtils;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * 基于注解的CRUD 单元测试
 * created by suger on 2018/9/17
 */
public class UserAnnotationDaoTest {


    private ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    private UserAnnotationDao userAnnotationDao = ctx.getBean(UserAnnotationDao.class);
    private static Logger log = Logger.getLogger(UserAnnotationDaoTest.class);

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
        userAnnotationDao.insert(user);
        log.info("插入后Id:"+user.getUserId());
    }

    @Test
    public void update() throws Exception {
        Boolean flag = false;
        Long time = new Date().getTime();
        User user = new User();
        user.setProfession("UI");
        user.setUpdateAt(time);
        user.setUserId(10L);
        int i = userAnnotationDao.update(user);
        if (i!=0) {
            flag = true;
        }
        log.info("更新："+flag);
    }

    @Test
    public void delete() throws Exception {
        Boolean flag = false;
        Long userId = 9L;
        int i = userAnnotationDao.delete(userId);
        if (i!=0) {
            flag = true;
        }
        log.info("删除：" + flag);

    }

    @Test
    public void findAll() throws Exception {
        List users = userAnnotationDao.findAll();
        if(users!=null){
            log.info("查询成功");
        }
    }

    @Test
    public void getUserByName() throws Exception {
        List users = userAnnotationDao.getUserByName("金石开");
        log.info("查姓名为金石："+users);
    }

    @Test
    public void getUserByonlineId() throws Exception {
        List users = userAnnotationDao.getUserByonlineId(13590);
        log.info("查学号13590" + users);

    }

}