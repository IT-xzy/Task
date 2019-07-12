package com.test;


import com.pojo.User;
import com.service.UserService;
import com.serviceImpl.UserServiceImpl;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.sql.Timestamp;

/**
 * 单元测试
 */
public class MybatisTest {
    private Logger logger = Logger.getLogger(MybatisTest.class);
    UserService service = new UserServiceImpl();
    /**
     *增加
     */
    @Test

    public void testInsert() throws Exception {
        User user = new User();
        user.setId(null);
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
        service.insert(user);
    }
    /**
     *通过ID删除
     */
    @Test

    public void testDelete() throws Exception {
        service.deleteById(3L);
    }

    /**
     *更新
     */
    @Test

    public void testUpdate() throws Exception {
        User user = new User();
        user.setId(555L);
        user.setName("haha");
        user.setJob("打工仔");
        user.setCollege("牧专");
        service.update(user);
    }
    /**
     *通过ID查询
     */
    @Test

    public void testGetUserById() throws Exception {
        service.getUser(4L);
    }
    /**
     *通过条件查询
     */
    @Test

    public void testGetUserByCondition() throws Exception {
        service.getUserByCondition("王八蛋", 998);
    }
    /**
     *查询全表
     */
    @Test

    public void testGetAllUsers() throws Exception {
        service.getAllUsers();
    }

    /**
     * 模糊查询
     */
    @Test
    public void testGetByName() throws Exception {
        service.selectByName("王");
    }
}
