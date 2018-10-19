package com.task1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {

    private static String driver ="com.mysql.jdbc.Driver";
    private static String url="jdbc:mysql://localhost:3306/register?serverTimeZone=GMT%2B8&characterEncoding=utf8&useUnicode=true";
    private static String user="root";
    private static String password="123456";

    public  static Connection getConnection() {
        Connection conn=null;
        try {
            Class.forName(driver);
            conn =  DriverManager.getConnection(url, user, password);

        } catch (ClassNotFoundException e) {
             e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;

    }

}
