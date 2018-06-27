package com.ptteng;

import com.ptteng.dao.UserDao;
import com.ptteng.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserTest {
    @Autowired
    UserDao userDao;
    @Test
    public void testSave() throws Exception {
        User user = new User("daswf","123");
        userDao.saveUser(user);
    }
    @Test
    public void testFind() throws Exception{
        System.out.println(userDao.getUserByName("chenxin"));

    }
    @Test
    public void testDelete() throws Exception{
        System.out.println(userDao.deleteUserById(5L));
    }
    @Test
    public void testUpdate() throws Exception{
        List<User> list = userDao.getUserByName("n");
        System.out.println(list);
        User user= list.get(1);
        user.setAddress("万维网");
        System.out.println("测试更新结果：" + userDao.updateUser(user));
    }
}
