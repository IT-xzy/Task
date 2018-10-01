package com.lihoo.demo.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author lihoo
 * @Title: C3P0Utils
 * @ProjectName maven_test_4
 * @Description: TODO
 * @date 2018/7/22-11:39
 */


public class C3P0Utils {
    private static ComboPooledDataSource dataSource = new ComboPooledDataSource("mysql");


    /*
    *获取连接池对象
    *  @return
    */
    public static DataSource getDataSource() {
        return dataSource;
    }

    /*
    *从池中获取连接对象
    * return
     */
    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /*
    *释放资源
    * @param connection
     */
    public static void releaseConnection(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (pstmt !=  null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
