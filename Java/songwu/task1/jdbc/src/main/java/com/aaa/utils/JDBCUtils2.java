package com.aaa.utils;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;
import java.sql.*;
import java.util.LinkedList;
import java.util.Properties;


public class JDBCUtils2 {
    private static LinkedList<Connection> pool=new LinkedList<Connection>();
    private static String Driver = null;
    private static String url = null;
    private static String user = null;
    private static String password = null;

    static {
        try {
//           String path = JDBCUtils2.class.getClassLoader().getResource("db.properties").getPath();

//            FileInputStream r = new FileInputStream("src/db.properties");

            InputStream inputStream = JDBCUtils2.class.getClassLoader().getResourceAsStream("src/db.properties");

//            Reader r = new FileReader("src//db.properties");

            Properties properties = new Properties();
          properties.load(inputStream);
            Driver = properties.getProperty("Driver");
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            Class.forName(Driver);
            for(int i = 0; i<20;i++){
                    Connection connection = DriverManager.getConnection(url, user, password);
                    pool.add(connection);
                }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     public synchronized static Connection getConnection() {
        return pool.removeFirst();
     }

    public static void free(Connection connection){
        pool.add(connection);
    }





























////    public static void release(ResultSet resultset, PreparedStatement preparedstatement, Connection connection) {
////        if (resultset != null) {
////            try {
////                resultset.close();
////
////            } catch (Exception e) {
////                e.printStackTrace();
////            }
////            resultset = null;
////        }
////        if (preparedstatement != null) {
////            try {
////                preparedstatement.close();
////            } catch (Exception e) {
////                e.printStackTrace();
////            }
////            try {
////                preparedstatement = null;
////            } catch (Exception e) {
////                e.printStackTrace();
////            }
////        }
////        if (connection != null) {
////            try {
////                connection.close();
////            } catch (Exception e) {
////                e.printStackTrace();
////            }
////            connection = null;
////        }
////    }
////
//
}
