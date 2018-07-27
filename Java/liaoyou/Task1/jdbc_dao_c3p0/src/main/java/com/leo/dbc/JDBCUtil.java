package com.leo.dbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCUtil {
	
	Logger logger = (Logger) LogManager.getLogger("mylog");
	// 通过标识名来创建相应连接池
	private static DataSource dataSources = new ComboPooledDataSource("mysql");
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			
			conn = dataSources.getConnection();
		} catch (Exception e) {
//			e.printStackTrace();
			System.out.println(e);
		}
		return conn;
	}
	
	/*
	 *  负责数据库的关闭
	 */
	public static void close(Connection conn) {
		try {
			if(conn != null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
