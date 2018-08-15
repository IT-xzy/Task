package com.leo.dao;

import com.leo.dao.impl.StudentDaoImpl;
import com.leo.dbc.JDBCUtil;
import com.leo.pojo.Student;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.sql.Connection;
/*
*       最大问题，单独使用c3p0与在spring中使用c3p0特别需要注意的一点是二者配置文件写法不一样啊啊啊啊啊，
*       对于配置文件的写法，不同框架不同工具都不一样啊啊啊啊啊啊啊啊啊
* */
public class IStudentDaoTest {
	
	private static Logger logger = (Logger) LogManager.getLogger("mylog");
/*	Connection conn = JDBCUtil.getConnection();
	IStudentDao studentDao = new StudentDaoImpl(conn);*/
	
	@Test
	public void findById() throws Exception {
		long start_time = System.currentTimeMillis();
		logger.info("测试开始");
		for(int i=0; i<20000; i++){
			Connection conn = JDBCUtil.getConnection();
			IStudentDao studentDao = new StudentDaoImpl(conn);
			Student student = studentDao.findById((long)19);
			System.out.println(student);
//			有无关闭连接测试
			JDBCUtil.close(conn);
		}
		long end_time = System.currentTimeMillis();
		logger.info("测试结束");
		logger.info("用时："+(end_time-start_time));
	}
}