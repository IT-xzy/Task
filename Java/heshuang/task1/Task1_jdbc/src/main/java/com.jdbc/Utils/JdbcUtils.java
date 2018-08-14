package com.jdbc.Utils;
import java.sql.*;

public class JdbcUtils {
    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
             connection = DriverManager.getConnection("jdbc:mysql://www.test.com/task1","root","0214");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public static void Close(ResultSet resultSet, PreparedStatement preparedStatement,Connection connection){
        try {
            if (null !=resultSet){
                resultSet.close();
            }
            if (null !=preparedStatement){
                preparedStatement.close();
            }
            if (null !=connection){
                connection.close();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
