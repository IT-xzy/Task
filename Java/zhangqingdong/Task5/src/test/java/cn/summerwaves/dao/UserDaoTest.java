package cn.summerwaves.dao;

import cn.summerwaves.model.User;
import cn.summerwaves.service.IUserService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;
@ContextConfiguration(locations = {"classpath:ApplicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDaoTest {
    private static Logger logger = Logger.getLogger("StudentServiceImpl.class");

    @Resource
    private IUserService dao;
    @Test
    public void insertUser() throws Exception {
        User user = new User();
        user.setUsername("1234");
        user.setPassword("4321");
        dao.insertUser(user);
    }

}