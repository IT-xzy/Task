package com.RedisTest;

import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class RedisTest {

    private Jedis jedis;

    // private String name = "Usher";
    // private String age = "44";
    // private String sex = "male";

    /*
     * 测试用例启动前运行
     */
    @Before
    public void setup() {
        // 服务器ip
        String ip = "127.0.0.1";
        // 服务器端口
        int port = 6379;
        // 授权密码
       // String password = "Ytw-2015#Ehsan";
        // 链接redis服务器
        jedis = new Jedis(ip, port);
        // 授权
      //  jedis.auth(password);
    }

    /*
     * String测试
     */
@Test
public void TestRedis(){
    jedis.set("name","baichensong");
    System.out.println("成功"+ jedis.get("name"));
    jedis.append("name","-123");

}


    @Test
    public void stringTest() {
        // 添加数据
        jedis.set("name", "Usher");

        System.out.println("添加数据:" + jedis.get("name") + "\n");
        // 拼接数据
        jedis.append("name", "\040is very cool!");

        System.out.println("拼接数据:" + jedis.get("name") + "\n");
        // 删除数据
        jedis.del("name");

        System.out.println("删除数据:" + jedis.get("name") + "\n");

        // 设置多个数据
        jedis.mset("name", "Usher", "age", "24", "sex", "male");

        // 某个数据+
        jedis.incrBy("age", 10);

        System.out.println("姓名:" + jedis.get("name") + "\040年龄:"
                + jedis.get("age") + "\040性别:" + jedis.get("sex") + "\n");
    }

    /*
     * Map测试
     */

    @Test
    public void mapTest() {
        HashMap<String, String> map = new HashMap<String, String>();
        // 添加数据
        map.put("name", "Usher");
        map.put("age", "24");
        map.put("sex", "male");
        // 添加到redis中
        jedis.hmset("Information", map);

        System.out.println("添加Map数据:"
                + jedis.hmget("Information", "name", "age", "sex") + "\n");
        // 删除数据
        jedis.hdel("Information", "name");

        System.out.println("删除Map数据:" + jedis.hmget("Information", "name")
                + "\n");
        // 返回key=Information的值的个数
        System.out.println("返回key=Information的值的个数:"
                + jedis.hlen("Information") + "\n");
        // 判断是否存在key=Information的对象
        System.out.println("判断是否存在key=Information的对象:"
                + jedis.exists("Information") + "\n");
        // 返回map对象中的所有key值
        System.out.println("返回map对象中的所有key值:" + jedis.hkeys("Information")
                + "\n");
        // 返回map对象中的所有value值
        System.out.println("返回map对象中的所有value值:" + jedis.hvals("Information")
                + "\n");
        // 循环迭代key
        Iterator<String> it = jedis.hkeys("Information").iterator();
        // 判断是否有元素存在
        while (it.hasNext()) {
            // 获取元素key
            String key = it.next();
            System.out.println("返回key为" + key + "的值:"
                    + jedis.hmget("Information", key) + "\n");
        }
    }

    /*
     * List测试
     */

    @Test
    public void listTest() {
        // 先清空List
        jedis.del("Information");
        // 查看List是否清空
        System.out.println("Lis[清空后]t:" + jedis.lrange("Information", 0, -1)
                + "\n");
        // 添加数据
        jedis.lpush("Information","usera");
        jedis.lpush("Information", "sex");
        jedis.lpush("Information", "age");
        // 查看List元素
        System.out.println("List[添加后]:" + jedis.lrange("Information", 0, -1)
                + "\n");
        // 清空List
        jedis.del("Information");
        // 添加数据
        jedis.lpush("Information", "Elliot");
        jedis.lpush("Information", "sex");
        jedis.lpush("Information", "age");
        // 查看List元素
        System.out.println("List[清空+添加]:" + jedis.lrange("Information", 0, -1)
                + "\n");
    }

    /*
     * set测试
     */

    @Test
    public void setTest() {
        // 添加元素
        jedis.sadd("user", "Usher");
        jedis.sadd("user", "sex");
        jedis.sadd("user", "age");
        System.out.println("Key的value值[删除前]:" + jedis.smembers("user") + "\n");
        // 删除元素
        jedis.srem("user", "age");
        // 所有元素的value()
        System.out.println("Key的value值[删除后]:" + jedis.smembers("user") + "\n");
        // 判断值是否存在
        System.out.println("判断值是否存在:" + jedis.sismember("user", "age") + "\n");
        // 返回集合元素的个数
        System.out.println("返回集合元素的个数:" + jedis.scard("user") + "\n");
        // 返回随机元素
        System.out.println("返回随机元素:" + jedis.srandmember("user") + "\n");
    }

    /*
     * jedis 排序
     */

    @Test
    public void sortTest() {
        // 添加元素
        jedis.rpush("sort", "1");
        jedis.lpush("sort", "2");
        jedis.lpush("sort", "3");
        jedis.lpush("sort", "4");
        System.out.println("元素:" + jedis.lrange("sort", 0, -1) + "\n");
        // 排序
        System.out.println("排序:" + jedis.sort("sort") + "\n");
        // jedis.sort("sort");
        // 再输出一次
        // System.out.println("元素:" + jedis.lrange("sort", 0, -1) + "\n");
    }

    /*
     * 测试中文
     */

    @Test
    public void chineseTest() {
        RedisUtil.getJedis().set("name", "中文测试");
        System.out.println(RedisUtil.getJedis().get("name"));
    }


    @Test
    public void hashMap(){
        Map< String, String> map = new HashMap<>();
        map.put("aa", "@sohu.com");

        map.put("bb","@163.com");

        map.put("cc", "@sina.com");

        System.out.println("普通的遍历方法，通过Map.keySet遍历key和value");//普通使用，二次取值

        for (String key : map.keySet()) {

            System.out.println("key= "+key+" and value= "+map.get(key));

        }
    }
}

