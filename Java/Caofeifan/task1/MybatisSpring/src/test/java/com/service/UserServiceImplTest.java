package com.service;

import com.model.User;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.annotation.Resource;
import java.sql.Timestamp;

@RunWith(SpringJUnit4ClassRunner.class)
/**引入一个文件*/
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})

/**
 * 单元测试
 */
public class UserServiceImplTest {
    private Logger logger = Logger.getLogger(UserServiceImplTest.class);
    @Resource
    private UserService userService;

    /**
     * 查询全表
     */
    @Test
    public void findAll() throws Exception {
        logger.info(userService.findAll());
    }

    /**
     * 模糊查找
     */
    @Test
    public void findByName() throws Exception {
        logger.info(userService.selectByName("王"));
    }

    /**
     * 通过ID查询
     */
    @Test
    public void findById() throws Exception {
        logger.info(userService.findById(2L));
    }

    /**
     * 条件查询
     */
    @Test
    public void findByCondition() throws Exception {
        logger.info(userService.findByCondition("王八蛋", 998));
    }

    /**
     * 增加
     */
    @Test
    public void add() throws Exception {
        User user = new User();
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
        userService.add(user);
        logger.info(user.getId());
    }

    /**
     * 删除
     */
    @Test
    public void deleteById() throws Exception {
        userService.deleteById(2L);
    }

    /**
     * 更新
     */
    @Test
    public void update() throws Exception {
        User user = new User();
        user.setId(6L);
        user.setName("刘德华");
        user.setQq(10000);
        userService.update(user);
    }
}
