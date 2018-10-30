package com.leo.server;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Belong:
 * @Description:
 * @Author: jk-leo
 * @Date: 2018/10/2 20:59
 */
public class RMIServer {
	
	public static void main(String[] args){
		System.out.println("服务端将要启动");
		new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println("服务端已经启动");
	}
}
