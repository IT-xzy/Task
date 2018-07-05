package crud.connection;

import java.io.IOException;
import java.net.URL;
import java.sql.*;

public class DatabaseConnection
{
    private static final String URL = "jdbc:mysql://localhost:3306/jnshu_db?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "123456";
    private Connection conn = null;


       public void DbConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASS);


        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Connection getconnection(){return this.conn;}
    public void close() {
        try  {
            if (this.conn != null) ;this.conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
