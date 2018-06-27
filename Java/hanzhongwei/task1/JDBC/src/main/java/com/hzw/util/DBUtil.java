package com.hzw.util;


import java.sql.*;
import java.util.ResourceBundle;

public class DBUtil {
    public static String DRIVER;
    public static String URL;
    public static String USERNAME;
    public static String PASSWORD;


    private DBUtil() {
    }

    private static ResourceBundle rb = ResourceBundle.getBundle("mysql");


    static {
        DRIVER = rb.getString("jdbc.driver");
        URL = rb.getString("jdbc.url");
        USERNAME = rb.getString("jdbc.username");
        PASSWORD = rb.getString("jdbc.password");
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("加载驱动失败");
        }
    }
    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("获取连接失败");
        }
        return conn;
    }

    public static void close(ResultSet rs, Statement state, Connection conn) {
        try {
            if (rs != null)
                rs.close();
            if (state != null)
                state.close();
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库关闭失败");
        }
    }
}
