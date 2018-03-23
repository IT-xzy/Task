import com.ycc.mapper.UserMapperI;
import com.ycc.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"classpath*:spring.xml"} )
public class UserDaoTest {
   @Resource
   UserMapperI userMapper;

    Logger logger = LoggerFactory.getLogger(UserDaoTest.class);

    @Test
    public void getUserById() throws Exception {
        try {
            User user =userMapper.getUserById(2);
            logger.info("用户:{}",user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getUserByName() throws Exception {
        try {
            User user = userMapper.getUserByName("李四");
            logger.info("根据名字查找：{}",user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getUserByNumber() throws Exception {
        try {
            User user=userMapper.getUserByNumber(123);
            logger.info("根据学号查找：{}",user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addUser() throws Exception {
        int retResult=0;
        User user = new User();
        try {
            List<User> userList = new ArrayList<>();
            user.setId(2);
            user.setStu_name("张三");
            user.setNumber(123);
            user.setQq(323213);
            user.setType("后端");
            user.setUniversity("家里蹲大学");
            user.setLink("www.nihao.com");
            user.setPledge("无敌");
            user.setSenior("随便");
            user.setLocality("知乎");
            user.setCreate_at(System.currentTimeMillis());
            user.setUpdate_at(System.currentTimeMillis());
            userList.add(user);
            retResult=userMapper.addUser(userList);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (retResult != -1) {
                logger.info("添加用户,ID为：{}", user.getId());
            } else {
                logger.info("添加失败");
            }
        }

    }

    @Test
    public void updateUser() throws Exception {
        int retResult=0;
        try {
            User user = new User();
            user.setId(1);
            user.setStu_name("da");
            user.setNumber(123);
            user.setQq(323213);
            user.setType("后端");
            user.setUniversity("家里蹲大学");
            user.setTime(System.currentTimeMillis());
            user.setLink("www.nihao.com");
            user.setPledge("无敌");
            user.setSenior("随便");
            user.setLocality("知乎");
            user.setUpdate_at(System.currentTimeMillis());
            retResult=userMapper.updateUser(user);
//        assertTrue("更新数据{}",ret==1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (retResult != -1) {
                logger.info("更新数据：{}", true);
            } else {
                logger.info("更新数据：{}",false);
            }
        }
    }

    @Test
    public void deleteUser() throws Exception {
        int retResult=0;
        try {
            retResult=userMapper.deleteUser(1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (retResult != -1) {
                logger.info("删除数据：{}", true);
            } else {
                logger.info("删除数据：{}",false);
            }
        }

    }

    @Test
    public void getAllUser() throws Exception {
        try {
            List<User> userList=userMapper.getAllUser();
            Iterator it = userList.iterator();
            while (it.hasNext()) {
                logger.info("所有用户：{}",it.next());
            }
//            for (User i : userList) {
//                logger.info("所有用户：{}",i);
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}