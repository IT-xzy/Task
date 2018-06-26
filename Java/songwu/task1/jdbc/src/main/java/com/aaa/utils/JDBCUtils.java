package com.aaa.utils;


import java.sql.*;

public class JDBCUtils {
    // 数据库 URL
    private static String url = "jdbc:mysql://localhost:3306/task2";



    // 数据库的用户名与密码
    private static String user = "root";
    private static String password = "123";

    //无参构造方法初始化类
    private JDBCUtils() {

    }

    static {
        try {
            //加载Jdbc驱动
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //通过调用此方法建立连接
    public static Connection getConnection() throws SQLException {
        return (Connection) DriverManager.getConnection(url, user, password);

    }
    //释放资源的方法，通过调用避免代码的繁琐
    public static void free(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection) {
        try {
            //关闭连接
            if (resultSet != null)
                resultSet.close();
            //如果出现异常交jvm处理，并将错误打印到控制台
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {

                if (preparedStatement != null)
                    preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (connection != null)
                    try {
                        connection.close();

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
            }
        }
    }

}
