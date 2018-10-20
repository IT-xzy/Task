package com.jnshu.jdbc;

import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

@Component
public class JdbcUntils {
    private static String driver = null;
    private static String url = null;
    private static String username = null;
    private static String password = null;

    //加载驱动
    static {
        try {
            //db.properties里面有连接数据库所需要的信息
            InputStream in = JdbcUntils.class.getClassLoader().getResourceAsStream("db.properties");
            Properties prop = new Properties();
            prop.load(in);//加载配置文件
            driver = prop.getProperty("driver");
            url = prop.getProperty("url");
            username = prop.getProperty("username");
            password = prop.getProperty("password");

            Class.forName(driver);//加载驱动

        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static Connection getConnecttion() throws Exception {
        //获取Connection
        return DriverManager.getConnection(url, username, password);
    }

}