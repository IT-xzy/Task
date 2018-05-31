package com.ptteng;

import com.ptteng.dao.UserDao;
import com.ptteng.model.User;
import com.ptteng.util.MemcacheUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import java.io.*;
import java.util.Date;
import java.util.List;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
//@TransactionConfiguration(transactionManager = "transactionManager",defaultRollback = true)
public class memcachedTest {
    @Test
    public void sava() throws IOException {
        MemcacheUtil memcacheUtil = new MemcacheUtil();
        User user = new User();
        user.setUsername("张三");
        user.setPassword("oiuoiuo");
        user.setCreatedAt(System.currentTimeMillis());
        memcacheUtil.saveKyeAndValue("test2", user);
        User user1 = (User) memcacheUtil.getValue("test2");
        System.out.println(user1.getUsername()+"\n" + user1.getPassword());
        System.out.println(new Date(user1.getCreatedAt()));
        ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream(new File("C:/user.txt")));
        oos.writeObject(user);
        System.out.println("对象序列化成功！");
        oos.close();

    }
    @Test
    public void k() throws IOException, ClassNotFoundException {
        ObjectInputStream ois= new ObjectInputStream(new FileInputStream(new File("c:/user.txt")));
        User user= (User) ois.readObject();
        System.out.println(user.toString());
    }
    @Autowired
    UserDao userDao;
    @Test
    public void saveList() throws Exception {
        MemcacheUtil memcacheUtil= new MemcacheUtil();
        List<User> userList = userDao.getUserByName("chenxin");
        System.out.println(userList.toString());
        memcacheUtil.saveKyeAndValue("test3", userList);
    }
    @Test
    public void GET(){
        MemcacheUtil memcacheUtil= new MemcacheUtil();
        List<User> userList= (List<User>) memcacheUtil.getValue("test3");
        System.out.println(userList.toString());
        System.out.println(userList.get(1).getUsername());
    }
    @Autowired
    MemcacheUtil memcacheUtil = new MemcacheUtil();
    @Test
    public void isExist(){
        System.out.println(memcacheUtil.getValue("test3"));
        System.out.println(memcacheUtil.isExist("test3"));
        System.out.println(memcacheUtil.isExist("test"));
        System.out.println(memcacheUtil.isExist("y"));
    }
}
