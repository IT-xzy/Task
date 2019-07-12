package com.utils;

import java.sql.*;

/**
 * 工具类
 */
public class DBUtil {
    public static Connection getConnection() {
        /**
         * 声明数据库连接对象
         */
        Connection conn = null;
        try {
            /**
             *   加载数据库驱动类com.mysql.jdbc.Driver
             */
            Class.forName("com.mysql.jdbc.Driver");
            /**
             * 获取数据库连接
             */
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?rewriteBatchedStatements=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT", "root", "CC188794496");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("获取连接失败");
        }
        return conn;
    }

    /**
     * 关闭所有资源
     */

    public static void closeAll(ResultSet rs, Statement stmt, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



