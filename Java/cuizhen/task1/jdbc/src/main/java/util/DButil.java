package util;

import java.sql.*;

public class DButil {

    private static String dburl="jdbc:mysql://127.0.0.1:3306/task?characterEncoding=UTF-8";
    private static String dbUserName="root";
    private static String dbPassword="5525";
    private static String jdbcName="com.mysql.jdbc.Driver";

    public static Connection getCon() throws SQLException {
        try {
            Class.forName(jdbcName);//找到驱动
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection con= DriverManager.getConnection(dburl,dbUserName,dbPassword);
        return con;
    }

    public static void close(PreparedStatement stmt, Connection con,ResultSet rs)throws  Exception {
        if (rs != null) {
            rs.close();
            if (stmt != null) {
                stmt.close();
                if (con != null) {
                    con.close();
                }
            }
        }
    }

    public static void close(PreparedStatement stmt, Connection con)throws  Exception {
            if (stmt != null) {
                stmt.close();
                if (con != null) {
                    con.close();
                }
            }
        }
}
