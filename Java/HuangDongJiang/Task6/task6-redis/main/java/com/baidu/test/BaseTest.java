package com.baidu.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/memcachedContext.xml")
public class BaseTest {
	protected static Log log = LogFactory.getLog(BaseTest.class);
	static {
			log.info("log4j.properties");
//			Log4jConfigurer.initLogging("WebContent/WEB-INF/config/log4j.properties");

	}
}
