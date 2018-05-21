package com.jdbcUtils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;
    static {
        try {
            InputStream in=JDBCUtils.class.getClassLoader().getResourceAsStream("db.properties");
            Properties prop=new Properties();//创建properties对象
            prop.load(in);//加载配置文件
            driver=prop.getProperty("driver");//读取配置文件里的信息，赋值给Driver
            url=prop.getProperty("yunUrl");
            username=prop.getProperty("username");
            password=prop.getProperty("password");
            Class.forName(driver);//加载驱动
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //连接数据库
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }
    //释放资源
    public static void release(Connection conn, PreparedStatement sql, ResultSet rs){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(sql!=null){
            try {
                sql.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
