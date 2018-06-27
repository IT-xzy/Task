package com.ptteng;

import com.google.gson.Gson;
import com.ptteng.dao.SignUserDao;
import com.ptteng.dao.StudentsDao;
import com.ptteng.dao.UserDao;
import com.ptteng.model.Student;
import com.ptteng.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Random;

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
    @Autowired
    StudentsDao studentsDao;
    @Test
    public void outputTest() throws Exception {
        List<Student> list = studentsDao.getall();
        Gson gson = new Gson();
        String jsonByGson = gson.toJson(list);

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("c:/user.txt")));
        objectOutputStream.writeObject(jsonByGson);

        ObjectOutputStream objectOutputStream1 = new ObjectOutputStream(new FileOutputStream(new File("c:/userList.txt")));
        String s = list.toString();
        objectOutputStream1.writeObject(list);
    }


    //
    @Autowired
    SignUserDao signUserDao;
    @Test
    public void sighedUserTest() throws Exception{
        System.out.println(signUserDao.get());
        System.out.println("****************");
        System.out.println(signUserDao.getById(3L));
    }
}
