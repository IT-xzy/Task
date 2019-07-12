package com.serviceImpl;

import com.model.User;
import com.service.UserService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.sql.Timestamp;

/**
 * 在使用所有注释前必须使用@RunWith(SpringJUnit4ClassRunner.class),让测试运行于spring环境
 */
@RunWith(SpringJUnit4ClassRunner.class)
/**引入一个文件*/
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class UserServiceImplTest {
    private Logger logger = Logger.getLogger(UserServiceImplTest.class);
    @Resource
    private UserService userService;

    /**
     * 查询全表
     */
    @Test
    public void getAllUser() throws Exception {
        logger.info(userService.findAll());
    }

    /**
     * 模糊查询
     */
    @Test
    public void testGetByName() throws Exception {
        logger.info(userService.selectByName("王"));
    }

    /**
     * 通过ID查询
     */
    @Test
    public void findById() throws Exception {
        logger.info(userService.findById(1L));
    }

    /**
     * 条件查询
     */
    @Test
    public void findByCondition() throws Exception {
        logger.info(userService.getUserByCondition("王八蛋", 998));
    }

    /**
     * 插入
     */
    @Test
    public void insert() throws Exception {
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
        userService.insert(user);
        logger.info(user.getId());
    }

    /**
     * 更新
     */
    @Test
    public void update() throws Exception {
        User user = new User();
        user.setId(25L);
        user.setName("哈哈");
        user.setQq(110);
        userService.update(user);
    }

    /**
     * 删除
     */
    @Test
    public void delete() throws Exception {
        userService.delete(5L);
    }
}
