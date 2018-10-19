package task06.util;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import task06.pojo.Category;

import java.util.HashMap;
import java.util.Map;



/**
 * ${file_name} Create on ${date}
 * Copyright (c) ${date} by taotaosoft
 *
 * @author <a href="1070800859@qq.com">* @Author: Mr.huang </a>
 * @version 1.0
 */
public class RedisUtilTest {
	public static void main(String[] args) throws Exception {
		@SuppressWarnings("resource")

		ApplicationContext context = new ClassPathXmlApplicationContext
				("classpath:spring/applicationContext-redis.xml");
		RedisUtil redisUtil = (RedisUtil) context.getBean("redisUtil");

		boolean isSuccess = redisUtil.set("age", 24);
		System.out.println("写入 age 是否成功：" + isSuccess);
		System.out.println(redisUtil.get("age"));
		System.out.println("---------------------------------------");

		boolean isSuccessAddr = redisUtil.set("address", "河北邯郸", 50);
		System.out.println("写入 address 是否成功：" + isSuccessAddr);
		System.out.println(redisUtil.get("address"));
		System.out.println("---------------------------------------");

		redisUtil.del("age");
		System.out.println("删除 age 是否成功：" + redisUtil.get("age"));
		System.out.println("---------------------------------------");

		redisUtil.del("a");
		long incr = redisUtil.incr("a", 9);
		System.out.println("incr ：" + incr);
		System.out.println("---------------------------------------");

		// Thread.sleep(5000);

		Map<String, Object> map = new HashMap<>();
		map.put("name", "王赛超");
		map.put("age", 24);
		map.put("address", "河北邯郸666");

		redisUtil.hmset("15532002725", map, 1000);
		System.out.println(map.toString());
		// System.out.println(redisUtil.get("15532002725").toString());
		System.out.println("---------------------------------------");


		redisUtil.del("15532002725");
		redisUtil.hset("15532002725", "address", "河北邯郸", 1000);

		redisUtil.hdel("15532002725", "name");
		System.out.println("---------------------------------------");
		System.out.println(redisUtil.sSetAndTime("15532002727", 1000, "haha"));
		System.out.println(redisUtil.sGet("15532002727"));
		System.out.println(redisUtil.sHasKey("15532002727", "name"));
		System.out.println(redisUtil.lRemove("15532002728", 1, 2));
		System.out.println(redisUtil.lGet("15532002728", 0, -1));
		System.out.println(redisUtil.lGetListSize("15532002728"));
		System.out.println(redisUtil.lGetIndex("15532002728", 1));


		System.out.println(redisUtil.getExpire("15532002725"));
		System.out.println(redisUtil.hget("15532002725", "name"));
		System.out.println(redisUtil.hmget("15532002725"));


		Category category = new Category();
		category.setId(12);
		// redisTemplate.se
		category.setName("88");
		String key = "88";

		redisUtil.set(key,SerializeUtil.serialize(category));

		redisUtil.set("88",category);
		Category d = (Category) redisUtil.get("88");
		System.out.println(d.toString());


	}

}