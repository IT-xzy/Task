package org.wyq.redis;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.*;

public class JedisUtil {
    JedisPool pool;
    Jedis jedis;
    private String value;

    @Before
    public void setUp() {
        pool = new JedisPool(new JedisPoolConfig(), "127.0.0.1");
        jedis = pool.getResource();
        jedis.auth("123456");
    }

    @Test
    public void testGet() {
        System.out.println(jedis.get("name"));
    }

    @Test
    public void testBasicString() {
//        添加数据
        jedis.set("name", "minxr");
        System.out.println(jedis.get("name"));
//        在原来数据后面添加数据
        jedis.append("name", "jarorwar");
        System.out.println(jedis.get("name"));//执行结果:minxrjarorwar
//        覆盖数据
        jedis.set("name", "wuyiqiang");
        System.out.println("name");
//        删除
        jedis.del("name");
        System.out.println(jedis.get("name"));
//        存入多个
        jedis.mset("name", "minxr", "jarorwar", "hahahah");
        System.out.println(jedis.get("name"));
        System.out.println(jedis.mget("name", "jarorwar"));

    }

    @Test
    public void testMap() {
        Map<String, String> user = new HashMap<String, String>();
        user.put("name", "minxr");
        user.put("pwd", "password");
        jedis.hmset("user", user);
//        key中key
        List<String> rsamp = jedis.hmget("user", "name");
        String hah = jedis.hmget("user", "name").getClass().toString();
        System.out.println(hah);
        System.out.println(rsamp);
        System.out.println(jedis.hlen("user")); //返回key为user的键中存放的值的个数1
        System.out.println(jedis.exists("user"));//是否存在key为user的记录 返回true
        System.out.println(jedis.hkeys("user"));//返回map对象中的所有key  [pwd, name]
        System.out.println(jedis.hvals("user"));//返回map对象中的所有value  [minxr, password]

        Iterator<String> iter = jedis.hkeys("user").iterator();
        while (iter.hasNext()) {
            String key = iter.next();
            System.out.println(key + ":" + jedis.hmget("user", key));
        }
    }

    @Test
    public void testList() {
        jedis.del("list");
        System.out.println(jedis.lrange("list", 0, -1));
        jedis.lpush("list", "spring");
        jedis.lpush("list", "struts");
        jedis.lpush("list", "hibernate");
//        -1表示取出全部
        System.out.println(jedis.lrange("list", 0, -1));
    }

    @Test
    public void testSet() {
        //添加   集合
        jedis.sadd("sname", "minxr");
        jedis.sadd("sname", "jarorwar");
        jedis.sadd("sname", "hehe");
        jedis.sadd("sanme", "noname");
        //移除noname
        jedis.srem("sname", "noname");
        System.out.println(jedis.smembers("sname"));//获取所有加入的value
        System.out.println(jedis.sismember("sname", "minxr"));//判断 minxr 是否是sname集合的元素
        System.out.println(jedis.srandmember("sname"));//返回一个随机值
        System.out.println(jedis.scard("sname"));//返回集合的元素个数
    }

    @Test
    public void test() throws InterruptedException {
        //keys中传入的可以用通配符
        System.out.println(jedis.keys("*")); //返回当前库中所有的key  [sose, sanme, name, jarorwar, foo, sname, java framework, user, braand]
        System.out.println(jedis.keys("*name"));//返回的sname   [sname, name]
        System.out.println(jedis.del("sanmdde"));//删除key为sanmdde的对象  删除成功返回1 删除失败（或者不存在）返回 0
        System.out.println(jedis.ttl("sname"));//返回给定key的有效时间，如果是-1则表示永远有效
        jedis.setex("timekey", 10, "min");//通过此方法，可以指定key的存活（有效时间） 时间为秒
        Thread.sleep(5000);//睡眠5秒后，剩余时间将为<=5
        System.out.println(jedis.ttl("timekey"));   //输出结果为5
        jedis.setex("timekey", 1, "min");        //设为1后，下面再看剩余时间就是1了
        System.out.println(jedis.ttl("timekey"));  //输出结果为1
        System.out.println(jedis.exists("key"));//检查key是否存在
        System.out.println(jedis.rename("timekey", "time"));
        System.out.println(jedis.get("timekey"));//因为移除，返回为null
        System.out.println(jedis.get("time")); //因为将timekey 重命名为time 所以可以取得值 min
        //jedis 排序
        //注意，此处的rpush和lpush是List的操作。是一个双向链表（但从表现来看的）
        jedis.del("a");//先清除数据，再加入数据进行测试
        jedis.rpush("a", "1");
        jedis.lpush("a", "6");
        jedis.lpush("a", "3");
        jedis.lpush("a", "9");
        System.out.println(jedis.lrange("a", 0, -1));// [9, 3, 6, 1]
        System.out.println(jedis.sort("a")); //[1, 3, 6, 9]  //输入排序后结果
        System.out.println(jedis.lrange("a", 0, -1));
    }

    @Test
    public void decrAndIncr() {
        jedis.set("age", "18");
        String age1 = jedis.get("age");
        System.out.println("当前年龄:" + age1);

        Long age2 = jedis.decr("age");
        System.out.println("一年前年龄为:" + age2);

        Long age3 = jedis.incr("age");
        System.out.println("现在年龄又变回为:" + age3);

//        查看有效期，-1表示持久化
        Long t = jedis.ttl("age");
        System.out.println(t);

//        对已经存在的key设置过期时间
        jedis.expire("age", 5);
        System.out.println(jedis.ttl("age"));

        //如果key不存在则忽略此操作
        Long del = jedis.del("age1");
    }

    @Test
    public void batch() {
        jedis.mset("a1", "mysql", "a2", "oracle", "a3", "sqlServer", "a4",
                "redis", "a5", "mongodb", "a6", "hbase");
        List<String> list = jedis.mget("a1", "a2", "a3", "a4", "a5", "a6");
        for (String s : list) {
            System.out.println(s);
        }
    }

    /*
     * 存储值的同时设置过期时间,判断key是否存在
     */
    @Test
    public void test4() throws InterruptedException {
        //jedis.setex(key, 过期时间, value)
        jedis.setex("life", 5, "享受美好");
        while (jedis.exists("life")) {
            System.out.println(jedis.get("life"));
            Thread.sleep(2000);
        }
    }

    @After
    public void after() {
        jedis.close();
    }
}
