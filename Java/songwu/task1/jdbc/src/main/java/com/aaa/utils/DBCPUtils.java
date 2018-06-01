package com.aaa.utils;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.annotation.Resource;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DBCPUtils {
    private static DataSource ds ;

    static {
        try {
//           Reader r= new FileReader("dbcp.properties");

            FileInputStream r = new FileInputStream("src/dbcp.properties");

//            InputStream r =DBCPUtils.class.getClassLoader().getResourceAsStream("src/dbcp.properties");

            Properties properties = new Properties();
            properties.load(r);
            BasicDataSourceFactory basicDataSourceFactory = new BasicDataSourceFactory();
           ds = basicDataSourceFactory.createDataSource(properties);
            System.out.println(ds);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static synchronized Connection getConnection() throws SQLException {
        Connection connection = ds.getConnection();
        return connection;
    }

    public static void free (ResultSet resultset, PreparedStatement preparedstatement, Connection connection) {
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