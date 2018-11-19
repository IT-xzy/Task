package task6_redis.util;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

@ContextConfiguration(locations = "classpath:spring-servlet.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class RedisUtilTest {
    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void testRedis() {
        String s = "String";
        List<String> list = new ArrayList<>();
        list.add("haiqing");
        list.add("海清");
        list.add("唐海清");
        Set<String> set = new HashSet<>();
        set.add("0");
        set.add("中国");
        set.add("2");
        Map<String, Object> map = new HashMap<>();
        map.put("key", "Str1");
        map.put("key2", "中国");
        map.put("key3", "str3");
        redisUtil.del("myStr", "str");

        //字符串操作
        redisUtil.set("str", s);
        redisUtil.expire("str", 120);
        String str = (String) redisUtil.get("str");
        System.out.println(str);
        //2.list操作
        redisUtil.lSet("list",list);
        redisUtil.expire("list",120);

        List<Object> list1 = redisUtil.lGet("list", 0, -1);
        //boolean b = redisUtil.lUpdateIndex("list", 1, "tanghaiqing");
        //System.out.println(b);
        System.out.println(list1.toString());
        //for (Object o : list) {
        //    System.out.println(o);
        //}
        //3.set操作
        //redisUtil.sSet("set",set);
        //redisUtil.expire("set",120);
        //Set<Object> set1 =redisUtil.sGet("set");
        //System.out.println(set1);
        redisUtil.del("goodShow");


    }
}