
import mapper.UserMapper;
import model.User;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * @Author qmz
 * @Description TODO
 * @Data 2018/6/24$ 16:44$
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestOne {
    private static Logger logger = Logger.getLogger(TestOne.class);
    @Autowired
    private UserMapper userMapper;
    @Autowired
    User user;

    //添加用户，返回id
    @Test
    public void testAddUser() {
        user.setName("小猪佩奇c");
        user.setQq(213123121);
        user.setType("java");
        userMapper.addUser(user);
        System.out.println("添加用户");
        long id = userMapper.findNewId(user);
        logger.info("id=====" + id);
    }

    //批量插入
    @Test
    public void testAddAll() {
        List<User> list = new ArrayList<>();
        Long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            list.add(user);
            user.setName("大杯子");
            user.setQq(213123121);
            user.setType("java");
            list.add(user);
            if (list.size() % 10 == 0) {
                userMapper.addAll(list);
                list.clear();
                logger.info("时间=====" + (System.currentTimeMillis() - start));
            }
        }
        if (list.size()!=0) {
            userMapper.addAll(list);
        }
        logger.info("时间=====" + (System.currentTimeMillis() - start));
    }

    //通过id删除用户
    @Test
    public void testDeleteUser() {
        user.setId(102L);
        boolean b = userMapper.deleteUser(user);
        logger.info("删除用户======" + b);
    }

    //更新用户信息
    @Test
    public void testUpdateUser() {
        user.setType("ui");
        user.setName("hehe");
        boolean b = userMapper.updateUser(user);
        logger.info("更新用户======" + b);
    }

    //通过name查询用户信息
    @Test
    public void testSeleteName() {
        user.setName("程荣强");
        User user1 = userMapper.selectName(user);
        logger.info("查询用户======" + user1.toString());
    }

    //查询
    @Test
    public void test6() {
        user.setType("ui");
        List<User> list = userMapper.selectUser(user);
        Long start = System.currentTimeMillis();
        for (User u : list) {
            logger.info(u.getName());
        }
        logger.info("时间=====" + (System.currentTimeMillis() - start));
    }
}
