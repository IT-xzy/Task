package com.aaa.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class C3p0Utils {

    // 为什么是静态的，因为想让数据源只有一份就可以了
    private static ComboPooledDataSource dataSource = null;

    static {
        // 数据源只能被初始化一次
        dataSource = new ComboPooledDataSource();
    }

    // // 获得数据源
    public static DataSource getDataSource() {
        return dataSource;
    }


    //从数据源中得到一个连接对象
    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("服务器错误");
        }
    }

    public static void free(ResultSet resultset, PreparedStatement preparedstatement, Connection connection) {
        if (resultset != null) {
            try {
                resultset.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
            resultset = null;
        }
        if (preparedstatement != null) {
            try {
                preparedstatement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                preparedstatement = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            connection = null;
        }
    }

}
