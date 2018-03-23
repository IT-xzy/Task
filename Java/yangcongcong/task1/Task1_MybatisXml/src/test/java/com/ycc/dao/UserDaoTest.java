package com.ycc.dao;

import com.ycc.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"classpath*:spring.xml"} )
public class UserDaoTest {
    @Resource
    UserDao userDao;


    Logger logger = LoggerFactory.getLogger(UserDaoTest.class);

    @Test
    public void getUserById() throws Exception {
        User user =userDao.getUserById(2);
        logger.info("用户:{}",user);
    }

    @Test
    public void getUserByName() throws Exception {
        try {
            User user = userDao.getUserByName("李四");
            logger.info("根据名字查找：{}",user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getUserByNumber() throws Exception {
        try {
            User user=userDao.getUserByNumber(123);
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
            user.setId(5);
            user.setStu_name("李四");
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
            retResult=userDao.addUser(userList);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (retResult ==1) {
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
            retResult=userDao.updateUser(user);
//        assertTrue("更新数据{}",ret==1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (retResult == 1) {
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
            retResult=userDao.deleteUser(2);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (retResult == 1) {
                logger.info("删除数据：{}", true);
            } else {
                logger.info("删除数据：{}",false);
            }
        }
    }

    @Test
    public void getAllUser() throws Exception {
        try {
            List<User> userList=userDao.getAllUser();
            for (User user : userList) {
                logger.info("所有用户：{}",user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}