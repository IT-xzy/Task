package test;

import com.Redis.RedisCacheUtil;
import com.Redis.redisTool;
import org.junit.Before;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    private redisTool redis;
    private static String key;
    private static Object value;

    @Before
    public void setUp() throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        context.start();
        redis = (redisTool) context.getBean("redis");
    }
    static {
        key = "tb_student";
        value = "一系列的关于student的信息！";
    }
    @org.junit.Test
    public void testHset() {
        redis.set(key,value);
        System.out.println(key);
        System.out.println("数据保存成功！");
    }

    // 测试查询数据
    @org.junit.Test
    public void testHget(){
        Object re = redis.get(key);
        System.out.println("得到的数据：" + re);
    }
}
