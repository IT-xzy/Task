package com.lyh.utils;

import java.io.*;
import java.sql.*;
import java.util.Properties;

public class JdbcUtils {
    static String driverClass = null;
    static String url = null;
    static String name = null;
    static String password = null;
    static {
        try {
            //获得一个properties对象
            Properties properties = new Properties();
            //用InputStream加载配置文件
            InputStream is = new FileInputStream(new File("src/main/resources/db.properties"));
            //加载properties文件
            properties.load(is);
            driverClass = properties.getProperty("driverClass");
            url = properties.getProperty("url");
            name = properties.getProperty("name");
            password = properties.getProperty("password");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConn(){
        Connection conn = null;
        try {
//            加载驱动
            Class.forName(driverClass);
            //静态代码块 ---> 类加载了，就执行。 java.sql.DriverManager.registerDriver(new Driver());
            //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            //DriverManager.getConnection("jdbc:mysql://localhost/test?user=monty&password=greatsqldb");
            //2. 建立连接 参数一： 协议 + 访问的数据库 ， 参数二： 用户名 ， 参数三： 密码。
            conn = DriverManager.getConnection(url, name, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    /**
     * 释放资源
     * @param conn
     * @param ps
     * @param rs
     */
    public static void release(Connection conn , PreparedStatement ps , ResultSet rs){
        closeRs(rs);
        closeSt(ps);
        closeConn(conn);
    }
    private static void closeRs(ResultSet rs){
        try {
            if(rs != null){
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            rs = null;
        }
    }
    private static void closeSt(PreparedStatement ps){
        try {
            if(ps != null){
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            ps = null;
        }
    }

    private static void closeConn(Connection conn){
        try {
            if(conn != null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            conn = null;
        }
    }
}
