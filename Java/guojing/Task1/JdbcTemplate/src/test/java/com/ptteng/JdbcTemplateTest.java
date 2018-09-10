package com.ptteng;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

public class JdbcTemplateTest {
    static Logger logger = Logger.getLogger(JdbcTemplateTest.class);

//    定义私有变量
    private UserDao userDao;
    @Before
//    给变量赋值，方法。这个可以多想想，很有用。
    public  void test(){
        userDao=new UserDaoImpl();
    }



    @Test
    public void insertTest() {
        User user = new User();
        user.setName("刘备");
        user.setQQ(60179964);
        user.setWish("好好学习，天天向上");
//        插入long型时间戳，是为了便于计算时间。
        user.setCreateAt(System.currentTimeMillis());
        user.setUpdateAt(System.currentTimeMillis());
//        返回值指向一个long型对象
        Long result = userDao.insertUser(user);
        logger.debug("result======"+result);
//        assert result ==32;     判断返回值是否与预期一致。
    }

    @Test
    public void findAllTest() {
        logger.debug(userDao.findAll());
    }


    @Test
    public void findByIdTest() {
        logger.debug(userDao.findById(3));
            }

    @Test
    public void updateTest() {
        User user = new User();
        user.setName("孙权");
        user.setQQ(6353487);
        user.setWish("加油！加油！");
        user.setCreateAt(System.currentTimeMillis());
        user.setUpdateAt(System.currentTimeMillis());
        user.setId(2);
        logger.debug(userDao.updateUser(user));
    }


    @Test
    public void deleteTest() {
       logger.debug(userDao.deleteUser(27));
    }

}
