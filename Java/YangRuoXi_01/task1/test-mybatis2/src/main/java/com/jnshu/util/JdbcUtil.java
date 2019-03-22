package com.jnshu.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;


public class JdbcUtil {
    Logger logger =  LogManager.getLogger("mylog");

    ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();

    //连接方法
    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = comboPooledDataSource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    //关闭方法
    public void close (Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
