package com.ptteng;

import com.ptteng.model.Student;
import com.ptteng.service.OccupationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import redis.clients.jedis.Jedis;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@TransactionConfiguration(transactionManager = "transactionManager",defaultRollback = true)
public class RedisTest {
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
        //反序列化为list
        //直接得到结果，按教程做的写循环一值报错EOFException。
        // 如果是循环得到M m = (M) is.readObject();
        /*list = (List<Student>) is.readObject();
        System.out.println(list.get(1));
        System.out.println("反序列化结果：");
        for (int p = 0; p < list.size(); p++) {
            System.out.println("第" + p + "个数据" + list.get(p));
        }*/
            if (student == null){
                break;
            }
            list.add(student);
        }


    }

}
