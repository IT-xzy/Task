package com.mvc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class mian {
	public static void main(String[] args) {
		ApplicationContext serveer = new ClassPathXmlApplicationContext("classpath:spring/*.xml");
	}
}
