package com.suger.util;

import org.apache.log4j.Logger;

import java.sql.*;

/**
 * jdbc连接工具类
 *
 * @author suger
 * @date 2018-09-12
 */
public class DBUtils {

    private static String driver;
    private static String url;
    private static String username;
    private static String password;
    static Logger log = Logger.getLogger(DBUtils.class);

    static {

        driver = "com.mysql.jdbc.Driver";

        url = " ";
        username = " ";
        password = " ";

    }

    public static Connection open() {
        Connection connection = null;
        try {
            Class.forName(driver);
            try {
                connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                log.debug("获取连接失败", e);
            }
        } catch (ClassNotFoundException e1) {
            log.debug("数据库驱动加载失败", e1);

        }
        return connection;
    }

    /**
     * 关闭数据库连接
     * @param rs
     * @param stat
     * @param conn
     */
    public static void close(ResultSet rs, Statement stat, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stat != null) {
                stat.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            log.debug("数据库没有正确关闭·连接",e);
        }
    }

    /**
     * 关闭数据库连接
     * @param conn
     */
    public static void close( Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            log.debug("数据库没有正确关闭·连接",e);
        }
    }
}
