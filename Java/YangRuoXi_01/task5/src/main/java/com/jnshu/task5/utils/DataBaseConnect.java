package com.jnshu.task5.utils;

import com.mchange.v2.c3p0.DriverManagerDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DataBaseConnect {

    public boolean getConnection() {

        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties");
        Properties dbProperties = new Properties();
        try {
            dbProperties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setPassword(dbProperties.getProperty("jdbc.password"));
        dataSource.setJdbcUrl(dbProperties.getProperty("jdbc.url"));
        dataSource.setUser(dbProperties.getProperty("jdbc.username"));
        dataSource.setDriverClass(dbProperties.getProperty("jdbc.driver"));

        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        System.out.println(connection);

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }

        return true;
    }

}
