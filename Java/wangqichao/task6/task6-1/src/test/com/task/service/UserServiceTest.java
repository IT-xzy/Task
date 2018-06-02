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
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//生成spring容器
@RunWith(SpringJUnit4ClassRunner.class)
//加载配置文件
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserServiceTest {
    //生成对象注入属性
    @Autowired
    UserDao userDao;
    private static Jedis jedis;
    //连接到服务器
    static {
        jedis=new Jedis("127.0.0.1",6379);
    }

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
    @Test
    public void testString() throws Exception {
        //测试是否成功
        System.out.println(jedis.ping());
        //设置存取键值对
      jedis.set("name","wangqichao");
        System.out.println(jedis.get("name"));
        //设置追加操作
        jedis.append("name","/王琦超");
        System.out.println(jedis.get("name"));
        //多个字段同时存取
        jedis.mset("age","20","address","zhejiang");
        System.out.println(jedis.mget("name","age","address"));
        //删除字段
        jedis.del("address");
        System.out.println(jedis.get("address"));

    }
    @Test
    public void testHash() throws Exception {
        //新建一个map暂时存储对象
        Map<String,String> map=new HashMap<>();
        map.put("name","wang");
        map.put("age","20");
        //将map存进user中
        jedis.hmset("user",map);
        //取出user中的指定字段
        System.out.println(jedis.hmget("user","name","age"));
       //获取所有fields
        System.out.println(jedis.hkeys("user"));
        //获取所有values
        System.out.println(jedis.hvals("user"));
        //获取filed数量
        System.out.println(jedis.hlen("user"));
        //迭代遍历输出值
        Iterator<String> iter = jedis.hkeys("user").iterator();
        while(iter.hasNext()) {
            String key = iter.next();
            System.out.println( key+"--"+jedis.hmget("user", key) );
        }
    }
    @Test
    public void testList() throws Exception {
        //先清理数据
        jedis.del("mates");
        //可以将一个或多个值插入列表头部
        jedis.lpush("mates","zhangsan","zhaosi");
        jedis.lpush("mates","lisi");
        //将一个元素插入已存在的列表头部
        jedis.lpushx("mates","wangwu");
       //顺序取出
        System.out.println(jedis.lrange("mates",0,3));
        //将一个或多个插入尾部
       jedis.rpush("mates","zhuba");
        System.out.println(jedis.lrange("mates",0,10));
        //也可以使用-1来表示最后一个元素
        System.out.println(jedis.lrange("mates",0,-1));
    }
    @Test
    public void testSet() throws Exception {
        //向set中存入多个元素
        jedis.sadd("website","美团","腾讯","阿里");
        jedis.sadd("website","百度");
        //存入重复元素
        jedis.sadd("website","阿里");
        //回去元素数量
        System.out.println(jedis.scard("website"));
        //提取元素
        System.out.println(jedis.smembers("website"));
        System.out.println(jedis.sscan("website","1"));

    }
    @Test
    public void testZset() throws Exception {
        //存入
        jedis.zadd("city",0,"杭州");
        jedis.zadd("city",0,"南京");
        jedis.zadd("city",2,"北京");
        jedis.zadd("city",1,"上海");
        System.out.println(jedis.zcard("city"));
        //按照score从大到小输出
        System.out.println(jedis.zrevrangeByScore("city",2,0));
    }

}