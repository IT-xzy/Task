package com.ptteng;


import com.ptteng.dao.StudentsDao;
import com.ptteng.dao.UserDao;
import com.ptteng.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import javax.jws.soap.SOAPBinding;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@TransactionConfiguration(transactionManager = "transactionManager",defaultRollback = true)
public class DaoTest {
//    @Autowired
//    OccupationDao occupationDao;
//    @Test
//    public void test() throws Exception{
////       System.out.println(occupationDao.getAll());
//    }

    @Autowired
    StudentsDao studentsDao;
    @Autowired
    UserDao userDao;
    @Test
    public void test2() throws Exception{
        System.out.println(studentsDao.getall());
    }
    @Test
    public void getByname() throws Exception{
        List<User> userList=userDao.getUserByName("chenxin");
        System.out.println(userList);
        for (User user : userList){
            if (user.getUsername().equals("chenxin3")){
                System.out.println(user);
                System.out.println(user.getId());
            }
        }
    }

}
