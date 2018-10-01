package com.lihoo.demo.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author lihoo
 * @Title: JdbcUtils
 * @ProjectName maven_test_5000000
 * @Description: TODO
 * @date 2018/7/24-19:35
 */


public class JdbcUtils {

        private static Properties props = null;

        // 只在JdbcUtils类被加载时执行一次！
        static {
            // 给props进行初始化，即加载dbconfig.properties文件到props对象中
            try {
                InputStream in = com.lihoo.demo.utils.JdbcUtils.class.getClassLoader().getResourceAsStream("dbconfig.properties");
                props = new Properties();
                props.load(in);
            } catch(IOException e) {
                throw new RuntimeException(e);
            }

            // 加载驱动类
            try {
                Class.forName(props.getProperty("driverClassName"));
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        // 获取连接!
        public static Connection getConnection() throws SQLException {
            // 得到Connection
            return DriverManager.getConnection(props.getProperty("url"),props.getProperty("username"),props.getProperty("password"));
        }

}
