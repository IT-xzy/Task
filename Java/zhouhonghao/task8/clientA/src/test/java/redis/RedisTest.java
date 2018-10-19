package redis;

import com.jns.utils.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RedisTest {
    private static final Logger logger = LoggerFactory.getLogger(RedisTest.class);
    public static void main(String[] args)
    {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        RedisUtil redisUtil = (RedisUtil) applicationContext.getBean("redisUtil");
        redisUtil.set("name", "王天");
        logger.info("读取name:"+redisUtil.get("name").toString());
    }
}
