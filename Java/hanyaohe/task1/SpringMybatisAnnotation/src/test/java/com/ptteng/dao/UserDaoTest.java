package com.ptteng.dao;

import com.ptteng.model.User;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:ApplicationContext.xml")
public class UserDaoTest {
    private static final Logger logger = Logger.getLogger(UserDaoTest.class);

    @Autowired
    private UserDao userDao;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void add() {
        User user = new User();
        user.setUsername("new User");
        user.setId(18);
        user.setPassword("698");
        Integer insertId = userDao.add(user);
        logger.info("插入数据的id为:" + insertId);
    }

    @Test
    public void delete() {
        User user = new User();
        user.setUsername("new User");
        userDao.delete(3);
    }

    @Test
    public void get() {
        User user = new User();
        user.setUsername("new User");
        user = userDao.get(0);

    }

    @Test
    public void update() {
        User user = new User();
        user.setUsername("new User3");
        user.setPassword("234");
        user.setId(100);
        Boolean success = userDao.update(user);
        logger.info("更新数据成功:" + success);
    }

    @Test
    public void list() {

        System.out.println(userDao);
        List<User> us=userDao.list();
        for (User user : us) {
            System.out.println(user.getUsername());
        }
    }

    @Test
    public void count() {
    }
}