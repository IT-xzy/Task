package com.task.service;

import com.task.dao.UserDao;
import com.task.models.User;
import com.task.utils.DESUtil;
import com.task.utils.EncryptionUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
//生成spring容器
@RunWith(SpringJUnit4ClassRunner.class)
//加载配置文件
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserServiceTest {
    //生成对象注入属性
    @Autowired
    UserDao userDao;
    @Test
    public void justAdd() {
        User user=new User(System.currentTimeMillis(),"wang","1024");
        String salt= EncryptionUtil.getNextSalt();
        user.setSalt(salt);
        String str=user.getPassword()+salt;
        String hashKey=EncryptionUtil.getSHA256Str(str);
        user.setHashKey(hashKey);
        userDao.addUser(user);
    }

    @Test
    public void justUpdate() {
      User user=new User();
      user.setPassword("1024");
      user.setId(1);
      user.setUpdatedAt(System.currentTimeMillis());
      userDao.updateUser(user);
    }

    @Test
    public void justDelete() {
        User user=new User("wang",0);
        userDao.updateLoginTime(user);

    }

    @Test
    public void listByName() throws Exception{
        DESUtil desUtil=new DESUtil();
        long loginTime=System.currentTimeMillis();
        String str1=desUtil.encryptFromLong(loginTime);
        System.out.println(str1);
        long str2=desUtil.decryptToLong(str1);
        System.out.println("l"+str2);
        System.out.println(desUtil.encrypt("wangqichao"));

    }
}