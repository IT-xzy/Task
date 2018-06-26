package com.ptteng;

import com.ptteng.model.Student;
import com.ptteng.service.OccupationService;
import com.ptteng.util.RedisUtil;
import com.ptteng.util.SerializableUtilForRedis;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import redis.clients.jedis.Jedis;

import java.io.*;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@TransactionConfiguration(transactionManager = "transactionManager",defaultRollback = true)
public class RedisHAHATest {
    @Autowired
    OccupationService occupationService;

    @Test
    public void connectTest() throws Exception {
        //测试连接
        Jedis jedis = new Jedis("localhost");
        jedis.set("connect", "is work?");
        System.out.println(jedis.get("connect"));
        System.out.println(jedis.hget("runoobkey", "name"));
        System.out.println(jedis.hgetAll("runoobkey"));
        //拿到数据表中集合，以存入缓存中。
        List<Student> students = occupationService.get1();
        //序列化
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(baos);
        objectOutputStream.writeObject(students);
        System.out.println(baos);
        jedis.set("students".getBytes(), baos.toByteArray());
        //反序列化
        byte[] i = jedis.get("students".getBytes());
        ByteArrayInputStream bis = new ByteArrayInputStream(i);
        ObjectInputStream is = new ObjectInputStream(bis);
        System.out.println(is);
        List<Student> list = null;
        while (true){
            Student student = (Student) is.readObject();
            if (student == null){
                break;
            }
            list.add(student);
        }
    }

    @Autowired
    SerializableUtilForRedis serializableUtilForRedis;

    @Autowired
    RedisUtil redisUtils;
    @Test
    public void set() throws Exception {
        List<Student> students = occupationService.get1();

        System.out.println(redisUtils.set("list", students));
        Object s = redisUtils.get("list");
        System.out.println("****************");
        System.out.println("从redis取的缓存："+s);
    }
    @Test
    public void setString() throws Exception{
        String key = "131";
        String value = "6782";
        System.out.println(redisUtils.set(key,value ));
        System.out.println("************");
        System.out.println(redisUtils.get(key));
    }
}
