package com.mutesaid.DBDemo.JDBCDemo;

import java.sql.*;

public class JDBCUtils {
    //获取连接
    public static Connection getConnection(String url, String driverName, String user, String password) {
        Connection conn = null;
        try{
            Class.forName(driverName);
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }

    //关闭连接
    public static void closeConnection(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        try{
            if (conn != null) {
                conn.close();
                conn = null;
            }
            if (pstmt != null) {
                pstmt.close();
                pstmt = null;
            }
            if (rs != null) {
                rs.close();
                rs = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
