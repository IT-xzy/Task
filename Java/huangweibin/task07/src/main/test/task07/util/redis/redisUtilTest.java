package task07.util.redis;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ${file_name} Create on ${date}
 * Copyright (c) ${date} by taotaosoft
 *
 * @author <a href="1070800859@qq.com">* @Author: Mr.huang </a>
 * @version 1.0
 */
public class redisUtilTest {
	ApplicationContext context1 = new ClassPathXmlApplicationContext
			("classpath:spring/applicationContext-redis.xml");



	@Test
	public void setRedisUtil(){
		RedisUtil redisUtil = (RedisUtil) context1.getBean("redisUtil");
		System.out.println(redisUtil.set("11", "11", 1000 * 60));
	}
}
