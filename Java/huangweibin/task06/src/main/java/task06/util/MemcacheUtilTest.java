package task06.util;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MemcacheUtilTest {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("spring/memcachedContext.xml");

		//设置key
		boolean isSuccess = MemcacheUtil.set("name", "china");
		System.out.println("是否成功：" + isSuccess);
		Object obj = MemcacheUtil.get("name");
		System.out.println("获取name:" + obj);
		Object isSuccess1= MemcacheUtil.get("a");
		System.out.println("删除是否成功：" + isSuccess1);

	}

}