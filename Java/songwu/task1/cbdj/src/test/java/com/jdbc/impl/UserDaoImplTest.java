package com.jdbc.impl;


import com.jdbc.dao.UserDao;
import com.jdbc.pojo.User;
import org.junit.Test;

import java.util.List;

/**
 * UserDaoImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>���� 8, 2018</pre>
 */
public class UserDaoImplTest {

    /**
     * Method: insert()
     */
    @Test
    public void testInsert() throws Exception {
        UserDao userdao = new UserDaoImpl();
        User user = new User();
        user.setSex("��");
        user.setName("����");
        user.setAddress("�人");
        userdao.insert(user);
        User user2 = new User();
    user2.setName("�������");
    userdao.insert(user2);


    }

    /**
     * Method: delete(int i)
     */
    @Test
    public void testDelete() throws Exception {
        UserDao userdao = new UserDaoImpl();
        userdao.delete(6);


    }


    @Test
    public void testUpdate() throws Exception {
        UserDao userdao = new UserDaoImpl();
        User user = new User();
        user.setId(7);
        user.setName("��");
        userdao.update(user);


    }

    /**
     * Method: selectById(int i)
     */
    @Test
    public void testSelectById() throws Exception {
        UserDao userdao = new UserDaoImpl();

        System.out.print(userdao.selectById(6));

    }

    /**
     * Method: selectAll()
     */
    @Test
    public void testSelectAll() throws Exception {
        UserDao userDao = new UserDaoImpl();
        List<User> list = userDao.selectAll();
        for (User user : list) {
            System.out.println(user);
        }


    }


}
