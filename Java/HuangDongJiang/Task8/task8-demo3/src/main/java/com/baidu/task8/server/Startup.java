package com.baidu.task8.server;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Startup {
	private static final Log log = LogFactory.getLog(Startup.class);
	public static void main(String[] args) {
		new ClassPathXmlApplicationContext(
				"classpath:spring/applicationContext.xml");
		log.info("开启了第一个服务");
	}
}